package br.com.fazendagame.modelos.produtoDerivadosDoLeite;

import br.com.fazendagame.modelos.Loja;

public class Derivado extends Loja {
    private int litrosDeLeiteParaProduzir;
    private String nomeDoDerivado;
    private double lucroDeVenda;
    private double custoParaFazer;
    public Derivado(String produto, int litrosDeLeiteParaProduzir, double lucroDeVenda, double custoParaFazer) {
        this.nomeDoDerivado = produto;
        this.litrosDeLeiteParaProduzir = litrosDeLeiteParaProduzir;
        this.lucroDeVenda = lucroDeVenda;
        this.custoParaFazer = custoParaFazer;
    }

    public int getLitrosDeLeiteParaProduzir() {
        return litrosDeLeiteParaProduzir;
    }

    public String getNomeDoDerivado() {
        return nomeDoDerivado;
    }

    public double getLucroDeVenda() {
        return lucroDeVenda;
    }

    public double getCustoParaFazer() {
        return custoParaFazer;
    }
    @Override
    public String toString() {
        return this.nomeDoDerivado;
    }

    /**
     * DERIVADO / litrosDeLeiteParaProduzir / lucroDeVenda / custoParaFazer
     * leitecondensado
     * cremedeleite
     * manteiga 15 38 15
     * requeijao 5 25 10
     * queijo 2 10 3
     */
}

