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

    public void produzir(Derivado derivado,Fazenda fazenda) {
        if (derivado.getCustoParaFazer() <= fazenda.getCaixa() & derivado.getLitrosDeLeiteParaProduzir() <= fazenda.getQuantidadeDeLeitePorLitro()) {
            fazenda.adicionarAoCaixa(derivado.getCustoParaFazer());
            fazenda.retirarLeite(derivado.getLitrosDeLeiteParaProduzir());
            fazenda.getListaDeDerivados().add(derivado);
            System.out.println("Você gastou: " + derivado.getCustoParaFazer() + " reais para produzir: " + derivado.getNomeDoDerivado() + ", seu caixa tem: " + fazenda.getCaixa()
                    + " e seu estoque de leite tem: " + fazenda.getQuantidadeDeLeitePorLitro() + " litros");
        } else {
            System.out.println("Dinheiro ou quantidade de leite não é suficiente para produzir\n"
                    + " dinheiro: " + fazenda.getCaixa() + " leite: " + fazenda.getQuantidadeDeLeitePorLitro());
        }
        //CRIAR METODO QUE ADICIONA O DERIVADO A UMA LISTA NA LOJA OU FAZENDA(NAO SEI), DEPOIS ADICIONAR AO ESTOQUE DA LOJA
        //
    }
    @Override
    public String toString() {
        return this.nome;
    }
}
