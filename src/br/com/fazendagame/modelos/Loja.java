package br.com.fazendagame.modelos;

import br.com.fazendagame.modelos.Fazenda;
import br.com.fazendagame.modelos.produtoDerivadosDoLeite.Derivado;

import java.util.ArrayList;

public class Loja extends Fazenda {
    protected double caixa;
    protected int identificacaoLoja;

    public double getCaixa() {
        return this.caixa;
    }

    protected static double valorPorCadaEspacoNoEstoque = 500.00;
    protected double valorPorCadaEspacoNoEstoque1 = 500.00;

    protected int tamanhoDoEstoque;

    public void setCaixa(double caixa) {
        this.caixa = caixa;
    }

    public void venderDerivados(Fazenda fazenda) {
        double refValorDeDerivados = 0;
        for (int i = 0; i < fazenda.getListaDeDerivados().toArray().length; i++) {
            refValorDeDerivados += fazenda.getListaDeDerivados().get(i).getLucroDeVenda();
        }
        fazenda.getListaDeDerivados().clear();
        fazenda.adicionarAoCaixa(refValorDeDerivados);
        System.out.println(refValorDeDerivados + " Reais de derivados vendidos, seu caixa tem: " + fazenda.getCaixa());
    }

    public static double getValorPorCadaEspacoNoEstoque() {
        return valorPorCadaEspacoNoEstoque;
    }

    public void aumentarEstoque(int tamanhoDoEstoque,Fazenda fazenda) {
        this.tamanhoDoEstoque += tamanhoDoEstoque;
        fazenda.retirarDoCaixa(this.valorPorCadaEspacoNoEstoque1);
        System.out.println("loja aumentada, para " + this.tamanhoDoEstoque +  " estoques, você tem " + fazenda.getCaixa());
    }
//CRIAR LOJA PARA VENDER O LEITE
}
