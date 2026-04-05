package contaBancaria;

public class ContaBancaria {
    protected int numero;
    protected double saldo;

    public ContaBancaria(int numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }
    
    public void depositar(double valor){
        this.saldo += valor;
    }

    public boolean sacar(double valor){
        if (this.saldo <= valor){
            this.saldo -= valor;
            return true;
        }
        else {
            System.out.println("Saldo Insuficiente!");
            return false;
        }
    }

    public double getSaldo(){
        return this.saldo;
    }
}
