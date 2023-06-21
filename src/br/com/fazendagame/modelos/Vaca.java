package br.com.fazendagame.modelos;

public class Vaca {
    private int producaoDeLeitePorDia = 8;
    protected int identificacaoVaca;
    private double valorDeCompra = 3800.00;
    private double espacoNecessarioPorMetroQuadrado = 15.00;

    public double getValorDeCompra() {
        return valorDeCompra;
    }

    public void setIdentificacaoVaca(int identificacaoVaca) {
        this.identificacaoVaca = identificacaoVaca;
    }

    public int getIdentificacaoVaca() {
        return identificacaoVaca;
    }

    public double getEspacoNecessarioPorMetroQuadrado() {
        return espacoNecessarioPorMetroQuadrado;
    }

    public int getProducaoDeLeitePorDia() {
        return producaoDeLeitePorDia;
    }

    public void setProducaoDeLeitePorDia(int producaoDeLeitePorDia) {
        this.producaoDeLeitePorDia = producaoDeLeitePorDia;
    }
    @Override
    public String toString() {
        return "vaca " + this.identificacaoVaca;
    }
}
