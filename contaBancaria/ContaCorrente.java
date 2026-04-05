package contaBancaria;

public class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;

    public ContaCorrente(int numero, double saldoInicial, double limiteChequeEspecial) {
        super(numero, saldoInicial);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= (this.saldo + this.limiteChequeEspecial)) {
            this.saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo Insuficiente (Limite do Cheque Excedido)");
            return false;
        }
    }
}
