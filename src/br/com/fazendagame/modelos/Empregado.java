package br.com.fazendagame.modelos;

import br.com.fazendagame.modelos.produtoDerivadosDoLeite.Derivado;

public class Empregado extends Fazenda{
    String nome;
    private double salarioPorMes = 1800.00;
    public Empregado(String nome, Fazenda fazendaQueTrabalha) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void ordenhar(Vaca vaca,Fazenda fazenda) {
        if (vaca.getProducaoDeLeitePorDia() > 0){
            fazenda.adicionarLeite(vaca.getProducaoDeLeitePorDia());
            vaca.setProducaoDeLeitePorDia(0);
            fazenda.listaDeVacasQueDaoLeite.remove(vaca);
            System.out.println("Vaca " + vaca.getIdentificacaoVaca() + " ordenhada, você tem: " + fazenda.getQuantidadeDeLeitePorLitro()
                    + " litros de leite produzido");
        } else {
            System.out.println("Esta vaca não tem mais leite hoje para retirar");
        }
    }

    public double getSalarioPorMes() {
        return salarioPorMes;
    }

    public void produzirDerivado(int i,Fazenda fazenda,Loja loja) {
        Derivado derivado = fazenda.getListaDeDerivadosParaProducao().get(i);
        loja.getListaDeDerivados().add(derivado);
        fazenda.retirarLeite(derivado.getLitrosDeLeiteParaProduzir());
        fazenda.retirarDoCaixa(derivado.getCustoParaFazer());
        System.out.println(derivado.getNomeDoDerivado() + " produzido! Sua lista de derivados é:\n" + loja.getListaDeDerivados()  );
        System.out.println("Seu caixa :" + fazenda.getCaixa() + "R$");
        System.out.println("A quantidade de litros é : " + fazenda.getQuantidadeDeLeitePorLitro() + "L");


    }


    @Override
    public String toString() {
        return this.nome;
    }
}