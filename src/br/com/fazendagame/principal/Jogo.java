package br.com.fazendagame.principal;

import br.com.fazendagame.modelos.*;
import br.com.fazendagame.principal.menus.MenuFazenda;
import br.com.fazendagame.principal.menus.MenuPrincipal;

import java.io.BufferedReader;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        //INICIO DE JOGO, CRIACAO DE FAZENDA
        //NOME DA FAZENDA
        Scanner leitura = new Scanner(System.in);
        System.out.println("escolha um nome para sua fazenda");
        String respostaNomeFazenda = leitura.nextLine();
        Fazenda fazenda = new Fazenda(respostaNomeFazenda);
        Loja loja = new Loja();
        //COMPRA DE PASTO
        System.out.println("""
                              ***SOBRE O PASTO***
                Hora de comprar pasto, o metro quadrado custa: 200.00,
                lembrando que uma vaca precisa pelo menos de 15m² para ser criada.
                Digite a medida que será comprada:\s""");
        int respostaTamanhoDoPasto = leitura.nextInt();
        Pasto pasto = new Pasto(respostaTamanhoDoPasto, fazenda);
        //COMPRA DE VACAS
        System.out.println("""
                             ***SOBRE AS VACAS***
                Seu pasto precisa de vacas, vamos começar comprando uma\s""");
        Vaca vaca1 = new Vaca();
        fazenda.comprarVaca(vaca1, pasto);
        //CONTRATO COM EMPREGADOS
        System.out.println("""
                             ***SOBRE EMPREGADOS***
                Para fazer os serviços gerais você precisara de empregados, vamos contratar\s""");
        Empregado empregado1 = new Empregado("Alexandre", fazenda);
        fazenda.contrataEmpregado(empregado1);
        //ORDENHAR VACAS
        System.out.println("""
                              ***SOBRE O LEITE***
                Você já tem tudo para começar a trabalhar, vamos mandar um empregado ordenhar uma vaca\s""");
        empregado1.ordenhar(vaca1, fazenda);
        System.out.println("""
                Uma vaca pode dar 8 litros de leite por dia,esse leite pode ser ultilizado para
                a producão de derivados e depois serem vendidos mas para isso voce precisara de um loja\s""");
        //SOBRE LOJA
        System.out.println("""
                              ***SOBRE LOJA***
                Para ganhar dinheiro com o leite produzido você precisará de uma loja.
                Uma loja com um estoque custa 500.00 reais, consiga esse dinheiro para comprar sua loja.\s""");
        //ESPLICACAO DO METODO PROXIMODIA E SUAS CONSEQUENCIAS
        System.out.println("""
                              ***SOBRE OS DIAS***
                Seus empregados terão um salario de:\s""" + empregado1.getSalarioPorMes() + """
                reais por mês,você poderá pular para o proximo dia a qualquer hora e ao completar 30 dias
                seus empregados serão pagos automaticamente Vamos pular para o proximo dia\s""");
        fazenda.proximoDia();
        System.out.println("Agora é com você, escolha uma opção para continuar: ");
        //COMECO PARA LOOPING DE JOGO
        Scanner scanner = new Scanner(System.in);
        int opcao;
        String nomeEmpregado;
        do {
            MenuPrincipal.exibirMenuPrincipal();
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1://exibe menu fazenda
                    MenuPrincipal.exibirMenuFazenda();
                    opcao = leitura.nextInt();
                    Scanner leituraOpcaoMenuFazenda = new Scanner(System.in);
                    switch (opcao) {
                        case 1://opção contratar empregado
                            System.out.println("Digite o nome do empregado");
                            nomeEmpregado = leituraOpcaoMenuFazenda.nextLine();
                            Empregado empregado = new Empregado(nomeEmpregado,fazenda);
                            fazenda.contrataEmpregado(empregado);
                            System.out.println("Sua lista de Empregados é: " + fazenda.getListaDeEmpregados());
                            break;
                        case 2://opção aumentar pasto
                            System.out.println("Digite o tamanho do pasto em m²");
                            respostaTamanhoDoPasto = leituraOpcaoMenuFazenda.nextInt();
                            pasto.aumentarTamanho(respostaTamanhoDoPasto,fazenda);
                            break;
                        case 3://opção comprar loja
                            int respostaTamanhoDoEstoque;
                            if (fazenda.getListaDeLoja().toArray().length < 1){
                                System.out.println("Digite quantos estoques para sua primeira loja, cada um custa: " + Loja.getValorPorCadaEspacoNoEstoque());
                                respostaTamanhoDoEstoque = leituraOpcaoMenuFazenda.nextInt();
                                fazenda.comprarLoja(loja,respostaTamanhoDoEstoque);
                            }else {
                                System.out.println("Digite quantos estoques quer comprar, cada um custa: " + Loja.getValorPorCadaEspacoNoEstoque());
                                respostaTamanhoDoEstoque = leituraOpcaoMenuFazenda.nextInt();
                                loja.aumentarEstoque(respostaTamanhoDoEstoque, fazenda);
                            }
                            break;
                        case 4://opcão comprar vaca
                            System.out.println("Quantas vacas você quer comprar?");
                            int respostaQVacas;
                            respostaQVacas = leituraOpcaoMenuFazenda.nextInt();
                            double valorTotalVacas = respostaQVacas * vaca1.getValorDeCompra();
                            if (valorTotalVacas <= fazenda.getCaixa()){
                                for (int i = 0; i < respostaQVacas; i++) {
                                    Vaca vaca = new Vaca();
                                    fazenda.comprarVaca(vaca, pasto);
                                }
                            } else {
                                System.out.println("O preço por essas vacas é de: " + valorTotalVacas + " você tem: " + fazenda.getCaixa());
                            }
                            break;
                    }
                    break;
                case 2://exibe menu pasto
                    MenuPrincipal.exibirMenuPasto();
                    opcao = leitura.nextInt();
                    Scanner leituraOpcaoMenuPasto = new Scanner(System.in);
                    switch (opcao) {
                        case 1://opção produzir leite
                            int quantasVacasOrdenhar = 0;
                            while (quantasVacasOrdenhar != fazenda.listaDeVacasQueDaoLeite.toArray().length) {
                                System.out.println("De quantas vacas você quer ordenhar? você tem: "+ fazenda.getListaDeVacas().toArray().length + " no total mas " + fazenda.listaDeVacasQueDaoLeite.toArray().length + " vacas dão leite");
                                quantasVacasOrdenhar = leitura.nextInt();
                                if (quantasVacasOrdenhar <= fazenda.listaDeVacasQueDaoLeite.toArray().length) {
                                    for (int i = 0; i < quantasVacasOrdenhar; i++) {
                                        int ref = 0;
                                        if (fazenda.listaDeVacasQueDaoLeite.get(ref).getProducaoDeLeitePorDia() == 8) {
                                            empregado1.ordenhar(fazenda.listaDeVacasQueDaoLeite.get(ref), fazenda);
                                        }
                                    }
                                } else {
                                    System.out.println("Você não tem tantas vacas que possam ser ordenhadas ordenhar");
                                    quantasVacasOrdenhar = fazenda.listaDeVacasQueDaoLeite.toArray().length;
                                }
                            }
                        case 2://opção produzir derivados
                            //codigo que mostre apenas os derivados possiveis de produzir, talvez seja mais pratico criar
                            //um metodo na classe fazenda que devolva apenas os derivados possiveis de fazer
                            //fazendo um codigo que exclua os derivados que o usuario não tenha leite ou dinheiro
                            //suficiente para produzir
                    }
                case 3://exibe menu loja
            }

        } while (opcao != 9);

        scanner.close();
    }



        //CRIAR PERGUNTAR SOBRE O QUE O USUARIO QUER FAZER
        //SE ELE QUER ORDENHAR, IR PARA O PROXIMO DIA, CONTRATAR MAIS EMPREGADOS, COMPRAR VACAS OU PASTO, BASEADO NO CAIXA
}
