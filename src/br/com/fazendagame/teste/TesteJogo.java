package br.com.fazendagame.teste;

import br.com.fazendagame.modelos.*;
import br.com.fazendagame.modelos.produtoDerivadosDoLeite.Derivado;

import java.util.ArrayList;
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
        fazenda.comprarLoja(loja,10);
        fazenda.comprarPasto(pasto,45);
        fazenda.comprarVaca(vaca1,pasto);
        fazenda.comprarVaca(vaca2,pasto);
        fazenda.comprarVaca(vaca3,pasto);
        System.out.println(pasto.getTamanho());

        Scanner leitura = new Scanner(System.in);
        int quantasVacasOrdenhar = 0;
        while (quantasVacasOrdenhar != fazenda.listaDeVacasQueDaoLeite.toArray().length) {
            System.out.println("De quantas vacas você quer ordenhar? você tem: " + fazenda.listaDeVacasQueDaoLeite.toArray().length + " vacas");
            quantasVacasOrdenhar = leitura.nextInt();
                if (quantasVacasOrdenhar <= fazenda.listaDeVacasQueDaoLeite.toArray().length) {
                    for (int i = 0; i < quantasVacasOrdenhar; i++) {
                        int ref =0;
                            empregado1.ordenhar(fazenda.listaDeVacasQueDaoLeite.get(ref), fazenda);
                    }
                } else {
                    System.out.println("Você não tem tantas vacas");
                    quantasVacasOrdenhar = fazenda.listaDeVacasQueDaoLeite.toArray().length;
                }
        }
    }
}
