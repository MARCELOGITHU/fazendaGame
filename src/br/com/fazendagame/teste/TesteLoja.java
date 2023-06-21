package br.com.fazendagame.teste;

import br.com.fazendagame.modelos.Empregado;
import br.com.fazendagame.modelos.Fazenda;
import br.com.fazendagame.modelos.Pasto;
import br.com.fazendagame.modelos.Vaca;
import br.com.fazendagame.modelos.Loja;
import br.com.fazendagame.modelos.produtoDerivadosDoLeite.Derivado;

public class TesteLoja {
    public static void main(String[] args) {
        Fazenda fazenda = new Fazenda("Matão");
        Pasto pasto = new Pasto();
        Loja loja = new Loja();
        Empregado empregado1 = new Empregado("carlos",fazenda);
        Empregado empregado2 = new Empregado("marta",fazenda);
        Vaca vaca1 = new Vaca();
        Vaca vaca2 = new Vaca();
        Derivado derivado1 = new Derivado("queijo",2,10,3);
        Derivado derivado2 = new Derivado("requeijao", 5,25,10);
        Derivado derivado3 = new Derivado("manteiga", 15,38,15);

        fazenda.contrataEmpregado(empregado1);
        fazenda.contrataEmpregado(empregado2);
        empregado1.ordenhar(vaca1,fazenda);
        empregado1.ordenhar(vaca2,fazenda);
        empregado1.produzir(derivado1,fazenda);
        empregado2.produzir(derivado2,fazenda);
        empregado1.produzir(derivado2,fazenda);
        System.out.println(fazenda.getListaDeDerivados());
        fazenda.proximoDia();
        empregado1.ordenhar(vaca1,fazenda);
        empregado1.ordenhar(vaca2,fazenda);
        empregado1.produzir(derivado3,fazenda);

        System.out.println(fazenda.getListaDeDerivados());

        loja.venderDerivados(fazenda);

        System.out.println(fazenda.getListaDeEmpregados());

        System.out.println(fazenda.listaDeVacasQueDaoLeite);

        //PELO QUE PARECE JA FORAM CRIADOS TODOS OS CODIGOS PARA COMEÇAR O JOGO
    }
}