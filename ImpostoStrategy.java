public interface ImpostoStrategy {
    double calcular(double valor);    
}

class Icms implements ImpostoStrategy {
    public double calcular(double valor) { return valor += (valor * 0.18); }
}

class Iss implements ImpostoStrategy {
    public double calcular(double valor) { return valor += (valor * 0.05); }
}

class CalculadoraImposto {
    private ImpostoStrategy estrategia;

    public void setEstrategia(ImpostoStrategy e) {
        this.estrategia = e;
    }

    public double calcular(double valor) {
        return estrategia.calcular(valor);
    }
}

class MainImposto {
    public static void main(String[] args) {
        CalculadoraImposto calculadora = new CalculadoraImposto();
        double valor = 100;

        calculadora.setEstrategia(new Icms());
        System.out.println("Icms: R$ " +
        calculadora.calcular(valor));

        calculadora.setEstrategia(new Iss());
        System.out.println("Iss: R$ " +
        calculadora.calcular(valor));
    }
}