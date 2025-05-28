package br.com.fazendagame.teste;

import br.com.fazendagame.modelos.*;
import br.com.fazendagame.modelos.produtoDerivadosDoLeite.Derivado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TesteJogo {
    public static void main(String[] args) {
        Fazenda fazenda = new Fazenda("Matão");
        Pasto pasto = new Pasto();
        Loja loja = new Loja();
        Empregado empregado1 = new Empregado("carlos",fazenda);
        Empregado empregado2 = new Empregado("marta",fazenda);
        Vaca vaca1 = new Vaca();
        Vaca vaca2 = new Vaca();
        Vaca vaca3 = new Vaca();

        fazenda.contrataEmpregado(empregado1);
        fazenda.contrataEmpregado(empregado2);
        fazenda.comprarLoja(loja);
        fazenda.comprarPasto(pasto,45);
        fazenda.comprarVaca(vaca1,pasto);
        fazenda.comprarVaca(vaca2,pasto);
        fazenda.comprarVaca(vaca3,pasto);
        System.out.println(pasto.getTamanho());

        empregado2.produzirDerivado(2,fazenda,loja);
        empregado2.produzirDerivado(2,fazenda,loja);

        loja.listaDeDerivadosResumido();


    }
}
