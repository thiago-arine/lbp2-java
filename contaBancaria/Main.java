package contaBancaria;

public class Main {

    public static void main(String[] args) {
        ContaPoupanca cp = new ContaPoupanca(1001, 500.0);
        cp.sacar(500.0);
        cp.renderJuros(0.1);
        System.out.println("Saldo: R$ " + cp.getSaldo());

        ContaCorrente cc = new ContaCorrente(1001, 200.0, 100.0);
        cc.sacar(400.0);
        System.out.println("Saldo: R$ " + cc.getSaldo());
    }
}
