package br.com.fazendagame.modelos.produtoDerivadosDoLeite;


import java.util.List;

public class Derivado {
    private final int litrosDeLeiteParaProduzir;
    private final String nomeDoDerivado;
    private final double lucroDeVenda;
    private final double custoParaFazer;

    public Derivado(String nomeDoDerivado,int litrosDeLeiteParaProduzir, double lucroDeVenda, double custoParaFazer) {
        this.litrosDeLeiteParaProduzir = litrosDeLeiteParaProduzir;
        this.nomeDoDerivado = nomeDoDerivado;
        this.lucroDeVenda = lucroDeVenda;
        this.custoParaFazer = custoParaFazer;


    }

    public int getLitrosDeLeiteParaProduzir() {
        return this.litrosDeLeiteParaProduzir;
    }

    public String getNomeDoDerivado() {
        return this.nomeDoDerivado;
    }

    public double getLucroDeVenda() {
        return this.lucroDeVenda;
    }

    public double getCustoParaFazer() {
        return this.custoParaFazer;
    }
    @Override
    public String toString() {
        return this.nomeDoDerivado;
    }

    /**
     * DERIVADO / litrosDeLeiteParaProduzir / lucroDeVenda / custoParaFazer
     * leitecondensado 50 73 40
     * cremedeleite 38 65 32
     * manteiga 25 50 20
     * requeijao 15 38 15
     * queijo 5 25 10
     * qualhada 2 10 3
     */
}

