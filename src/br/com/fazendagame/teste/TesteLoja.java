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

        fazenda.contrataEmpregado(empregado1);
        fazenda.contrataEmpregado(empregado2);
        empregado1.ordenhar(vaca1,fazenda);
        empregado1.ordenhar(vaca2,fazenda);
        fazenda.proximoDia();
        empregado1.ordenhar(vaca1,fazenda);
        empregado1.ordenhar(vaca2,fazenda);


//        loja.venderDerivados(fazenda);

        System.out.println(fazenda.getListaDeEmpregados());

        System.out.println(fazenda.listaDeVacasQueDaoLeite);
    }
}