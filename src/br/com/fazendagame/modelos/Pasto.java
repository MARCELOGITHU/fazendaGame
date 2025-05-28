package br.com.fazendagame.modelos;

public class Pasto extends Fazenda {
    protected int identificacaoPasto;
    protected double tamanho;
    protected double valorDeTamanhoPorMetroQuadrado = 200.00;

    public Pasto(double tamanhoPorMetroQuadrado, Fazenda fazenda) {
        this.identificacaoPasto = fazenda.pastoIdentificacao;
        fazenda.pastoIdentificacao ++;
        this.tamanho = tamanhoPorMetroQuadrado;
        double refCustoDoPasto = tamanhoPorMetroQuadrado*valorDeTamanhoPorMetroQuadrado;
        fazenda.retirarDoCaixa(refCustoDoPasto);
        System.out.println("Pasto de " + refCustoDoPasto + " reais, com " + this.tamanho +  " m² comprado, você tem " + fazenda.getCaixa());
    }

    public Pasto() {

    }

    public double getTamanho() {
        return this.tamanho;
    }

    public void aumentarTamanho(double tamanhoEmMetrosQuadrados,Fazenda fazenda) {
        if (valorDeTamanhoPorMetroQuadrado*tamanhoEmMetrosQuadrados <= fazenda.getCaixa()) {
            this.tamanho += tamanhoEmMetrosQuadrados;
            fazenda.pastoIdentificacao ++;
            double refCustoDoPasto = tamanhoEmMetrosQuadrados*valorDeTamanhoPorMetroQuadrado;
            fazenda.retirarDoCaixa(refCustoDoPasto);
            System.out.println(tamanhoEmMetrosQuadrados + " m² adicionado ao seu pasto, gasto de: " + refCustoDoPasto + " você tem: " + fazenda.getCaixa());
        }else {
            System.out.println("Sem saldo suficiente, preço do m²: " + valorDeTamanhoPorMetroQuadrado + "R$");
        }

    }
}
