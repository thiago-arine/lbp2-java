import java.util.Scanner;

interface PagamentoStrategy {
    double calcularTotal(double valor);
}

class Pix implements PagamentoStrategy {
    @Override
    public double calcularTotal(double valor) {
        return valor * 0.9;
    }
}

class CartaoCredito implements PagamentoStrategy {
    @Override
    public double calcularTotal(double valor) {
        return valor;
    }
}

class TED implements PagamentoStrategy {
    @Override
    public double calcularTotal(double valor) {
        // Apenas retorna o cálculo sem reatribuir à variável original
        return valor + 11.10;
    }
}

class PagamentoFactory {
    public static PagamentoStrategy criar(String tipo) {
        if (tipo.equalsIgnoreCase("Pix")) {
            return new Pix();
        } else if (tipo.equalsIgnoreCase("Credito")) {
            return new CartaoCredito();
        } else if (tipo.equalsIgnoreCase("TED")) {
            return new TED();
        }
        throw new IllegalArgumentException("Método de pagamento '" + tipo + "' não suportado...");
    }
}

class AuditoriaLog {
    private static AuditoriaLog instance;
    private AuditoriaLog() { }

    public static synchronized AuditoriaLog getInstance() {
        if (instance == null) {
            instance = new AuditoriaLog();
        }
        return instance;
    }

    public void registrar(double valor, String tipo) {
        // Usei printf para formatar as casas decimais do dinheiro
        System.out.printf("Pagamento de R$%.2f realizado via %s%n", valor, tipo);
    }
}

public class MainPagamento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double valorOriginal = 100.0;

        System.out.println("Valor da compra: R$" + valorOriginal);
        System.out.print("Digite o método de pagamento (Pix, Credito, TED): ");

        String metodoDesejado = sc.nextLine();

        PagamentoStrategy strategy = PagamentoFactory.criar(metodoDesejado);
        double valorFinal = strategy.calcularTotal(valorOriginal);

        AuditoriaLog.getInstance().registrar(valorFinal, metodoDesejado);

        sc.close();
    }
}