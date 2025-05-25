package br.com.fazendagame.teste;

import br.com.fazendagame.modelos.*;
import br.com.fazendagame.modelos.produtoDerivadosDoLeite.Derivado;

import java.util.ArrayList;
import java.util.List;

public class TesteProduzirDerivados {
    public static void main(String[] args) {

        Fazenda fazenda = new Fazenda("Matão");
        Pasto pasto = new Pasto(50,fazenda);
        Loja loja = new Loja();
        Empregado empregado1 = new Empregado("carlos",fazenda);
        Empregado empregado2 = new Empregado("marta",fazenda);
        Vaca vaca1 = new Vaca();
        Vaca vaca2 = new Vaca();
        fazenda.comprarVaca(vaca1,pasto);
        fazenda.comprarVaca(vaca2,pasto);

        fazenda.contrataEmpregado(empregado1);
        fazenda.contrataEmpregado(empregado2);
        empregado1.ordenhar(vaca1,fazenda);
//        empregado1.ordenhar(vaca2,fazenda);
        fazenda.getListaDeDerivadosPossiveisDeProduzir();

        empregado1.produzirDerivado(1,fazenda);
//        fazenda.proximoDia();
//        empregado1.ordenhar(vaca1,fazenda);
//        empregado1.ordenhar(vaca2,fazenda);
        fazenda.getListaDeDerivadosPossiveisDeProduzir();

        empregado1.produzirDerivado(2,fazenda);
        fazenda.getListaDeDerivadosPossiveisDeProduzir();

        System.out.println(fazenda.getListaDeDerivados().isEmpty());
    }
}