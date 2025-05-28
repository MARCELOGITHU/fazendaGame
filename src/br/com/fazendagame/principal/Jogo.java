package br.com.fazendagame.principal;

import br.com.fazendagame.modelos.*;
import br.com.fazendagame.modelos.produtoDerivadosDoLeite.Derivado;
import br.com.fazendagame.principal.menus.MenuFazenda;
import br.com.fazendagame.principal.menus.MenuPrincipal;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
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
                O metro quadrado de terreno para o pasto custa: 200.00,
                lembrando que uma vaca precisa pelo menos de 15m² para ser criada.
                Você irá iniciar com 30m²:\s""");
        int respostaTamanhoDoPasto;
        Pasto pasto = new Pasto(30, fazenda);
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
        fazenda.maoDeObra().ordenhar(vaca1, fazenda);
        System.out.println("""
                Uma vaca pode dar 8 litros de leite por dia,esse leite pode ser ultilizado para
                a producão de derivados e depois serem vendidos mas para isso voce precisara de um loja\s""");
        //SOBRE LOJA
        System.out.println("""
                              ***SOBRE LOJA***
                Para ganhar dinheiro com o leite produzido você precisará de uma loja.
                você irá iniciar sua loja.\s""");
        fazenda.comprarLoja(loja);
        //ESPLICACAO DO METODO PROXIMODIA E SUAS CONSEQUENCIAS
        System.out.println("""
                              ***SOBRE OS DIAS***
                Seus empregados terão um salario de:\s""" + fazenda.maoDeObra().getSalarioPorMes() + """
                reais por mês,você poderá pular para o proximo dia a qualquer hora e ao completar 30 dias
                seus empregados serão pagos automaticamente Vamos pular para o proximo dia\s""");
        fazenda.proximoDia();
        System.out.println("Agora é com você, escolha uma opção para continuar: ");
        //COMECO PARA LOOPING DE JOGO
        Scanner scanner = new Scanner(System.in);
        int opcaoGeral;
        String nomeEmpregado;
        do {
            MenuPrincipal.exibirMenuPrincipal();
            opcaoGeral = leitura.nextInt();

            switch (opcaoGeral) {
                case 1 -> {//exibe menu fazenda
                    MenuPrincipal.exibirMenuFazenda();
                    opcaoGeral = leitura.nextInt();
                    Scanner leituraOpcaoMenuFazenda = new Scanner(System.in);
                    switch (opcaoGeral) {
                        case 1 -> {//opção contratar empregado
                            System.out.println("Digite o nome do empregado");
                            nomeEmpregado = leituraOpcaoMenuFazenda.nextLine();
                            Empregado empregado = new Empregado(nomeEmpregado, fazenda);
                            fazenda.contrataEmpregado(empregado);
                            System.out.println("Sua lista de Empregados é: " + fazenda.getListaDeEmpregados());
                        }
                        case 2 -> {//opção aumentar pasto
                            System.out.println("Digite o tamanho do pasto em m²");
                            respostaTamanhoDoPasto = leituraOpcaoMenuFazenda.nextInt();
                            pasto.aumentarTamanho(respostaTamanhoDoPasto, fazenda);
                        }
                        case 3 -> {//opcão comprar vaca
                            System.out.println("Quantas vacas você quer comprar?");
                            int respostaQVacas;
                            respostaQVacas = leituraOpcaoMenuFazenda.nextInt();
                            double valorTotalVacas = respostaQVacas * vaca1.getValorDeCompra();
                            if (valorTotalVacas <= fazenda.getCaixa()) {
                                for (int i = 0; i < respostaQVacas; i++) {
                                    Vaca vaca = new Vaca();
                                    fazenda.comprarVaca(vaca, pasto);
                                }
                            } else {
                                System.out.println("O preço por essas vacas é de: " + valorTotalVacas + " você tem: " + fazenda.getCaixa());
                            }
                        }
                        case 4 -> {//opção resumo de bens
                            fazenda.resumoBens(loja,pasto);
                        }
                        case 5 -> {
                        }
                    }
                }
                case 2 -> {//exibe menu pasto
                    MenuPrincipal.exibirMenuPasto();
                    opcaoGeral = leitura.nextInt();
                    Scanner leituraOpcaoMenuPasto = new Scanner(System.in);
                    switch (opcaoGeral) {
                        case 1 -> {//opção produzir leite
                            int quantasVacasOrdenhar = 0;
                            System.out.println("De quantas vacas você quer ordenhar? você tem: " + fazenda.getListaDeVacas().toArray().length + " no total mas " + fazenda.listaDeVacasQueDaoLeite.toArray().length + " vacas dão leite");
                            quantasVacasOrdenhar = leitura.nextInt();
                            if (quantasVacasOrdenhar != 0 & quantasVacasOrdenhar <= fazenda.listaDeVacasQueDaoLeite.toArray().length ) {
                                for (int i = 0; i < quantasVacasOrdenhar; i++) {
                                    int ref = 0;
                                    if (fazenda.listaDeVacasQueDaoLeite.get(ref).getProducaoDeLeitePorDia() == 8) {
                                        fazenda.maoDeObra().ordenhar(fazenda.listaDeVacasQueDaoLeite.get(ref), fazenda);
                                    }
                                }
                            } else {
                                System.out.println("Você não tem tantas vacas que possam ser ordenhadas");
                            }
                        }
                        case 2 -> {//opção produzir derivados
                            if (fazenda.verificaListaDeDerivadosPossiveis()) {
                                System.out.println("Escolha o derivado a ser produzido");
                                System.out.println("DERIVADO / litrosDeLeiteParaProduzir / lucroDeVenda / custoParaFazer");
                                fazenda.getListaDeDerivadosPossiveisDeProduzir();
                                int selecionarDerivado = 0;
                                selecionarDerivado = leitura.nextInt();
                                if (selecionarDerivado <= fazenda.getQuantidadeDeDerivadospossiveis()) {
                                    fazenda.maoDeObra().produzirDerivado(selecionarDerivado, fazenda, loja);
                                } else {
                                    System.out.println("Opção invalida");
                                }
                            } else {
                                fazenda.getListaDeDerivadosPossiveisDeProduzir();
                                System.out.println("Não é possivel produzir");
                                System.out.println("Seu saldo é de :" + fazenda.getCaixa() + "R$, e " + fazenda.getQuantidadeDeLeitePorLitro() + "L");
                            }

                        }
                        case 3 -> {
                            fazenda.proximoDia();
                        }

                        case 4 -> {
                        }
                    }
                }
                case 3 -> {//exibe menu loja
                    MenuPrincipal.exibirMenuLoja();
                    opcaoGeral = leitura.nextInt();
                    Scanner leituraOpcaoMenuPasto = new Scanner(System.in);
                    switch (opcaoGeral) {
                        case 1 -> {//Vender derivados
                            if (!loja.getListaDeDerivados().isEmpty()) {
                                loja.venderDerivado(fazenda);
                            } else {
                                System.out.println("Sua lista de derivados esta vazia");
                            }
                        }
                        case 2 -> {//ver lista de derivados
                            loja.listaDeDerivadosResumido();
                        }
                        case 3 -> {
                        }
                    }
                }
                case 4 -> {//proximo dia
                    fazenda.proximoDia();
                }
            }
        } while (opcaoGeral != 9);

        scanner.close();
    }
}
