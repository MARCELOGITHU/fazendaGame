package br.com.fazendagame.modelos;

import br.com.fazendagame.modelos.Fazenda;
import br.com.fazendagame.modelos.produtoDerivadosDoLeite.Derivado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loja extends Fazenda {
    protected double caixa;
    protected int identificacaoLoja;

    public double getCaixa() {
        return this.caixa;
    }

    protected int tamanhoDoEstoque;
    private ArrayList<Derivado> listaDeDerivados = new ArrayList<>(tamanhoDoEstoque);

    public void setCaixa(double caixa) {
        this.caixa = caixa;
    }

    public void venderDerivado(Fazenda fazenda){
        double refValorDeDerivados = 0;
        for (int i = 0; i < this.getListaDeDerivados().toArray().length; i++) {
            refValorDeDerivados += this.getListaDeDerivados().get(i).getLucroDeVenda();
        }
        this.getListaDeDerivados().clear();
        fazenda.adicionarAoCaixa(refValorDeDerivados);
        System.out.println(refValorDeDerivados + " Reais de derivados vendidos, seu caixa tem: " + fazenda.getCaixa());
    }
    public List<Derivado> getListaDeDerivados() {
        return listaDeDerivados;
    }
    public void listaDeDerivadosResumido(){
        Map<Derivado, Integer> contagem = new HashMap<>();

        for (Derivado nome : this.listaDeDerivados) {
            contagem.put(nome, contagem.getOrDefault(nome, 0) + 1);
        }

        for (Map.Entry<Derivado, Integer> entrada : contagem.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }

    }

}
