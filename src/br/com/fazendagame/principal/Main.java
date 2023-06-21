package br.com.fazendagame.principal;

import br.com.fazendagame.modelos.Empregado;
import br.com.fazendagame.modelos.Fazenda;
import br.com.fazendagame.modelos.Pasto;
import br.com.fazendagame.modelos.Vaca;
import br.com.fazendagame.modelos.Loja;

/*PROGRAMA QUE DEMONSTRA O FUNCIONAMENTO DE UMA FAZENDA DE VACAS,
COM UM NEGOCIO DE VENDAS DE DERIVADOS DO LEITE
 */
public class Main {
    public static void main(String[] args) {
        //AREA DE CRIAÇÃO DOS OBJETOS
        Fazenda fazenda = new Fazenda("Matão");
        Pasto pasto = new Pasto();
        Loja loja = new Loja();
        Vaca vaca1 = new Vaca();
        Vaca vaca2 = new Vaca();
        Empregado empregado1 = new Empregado("carlos", fazenda);
        Empregado empregado2 = new Empregado("marta", fazenda);


        //AREA DE ULTILIZAÇÃO DE METODOS
        fazenda.contrataEmpregado(empregado1);
        fazenda.contrataEmpregado(empregado2);

        //

        empregado1.ordenhar(vaca1,fazenda);
        empregado1.ordenhar(vaca2,fazenda);


    }
}