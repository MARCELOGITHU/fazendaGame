package br.com.fazendagame.modelos;

import br.com.fazendagame.modelos.produtoDerivadosDoLeite.Derivado;

import java.util.ArrayList;

public class Fazenda {
    private String nomeFazenda;
    private double caixa = 30000.00;
    private double quantidadeDeLeitePorLitro;
    protected int dia = 1;
    protected int contagemDeMes = 1;
    protected int vacaIdentificacao = 1;
    protected int pastoIdentificacao = 1;

    protected int lojaIdentificacao = 1;
    private ArrayList<Empregado> listaDeEmpregados = new ArrayList<>();
    private ArrayList<Loja> listaDeLoja = new ArrayList<>();
    private ArrayList<Pasto> listaDePasto = new ArrayList<>();
    private ArrayList<Derivado> listaDeDerivados = new ArrayList<>();
    protected ArrayList<Vaca> listaDeVacas = new ArrayList<>();
    public ArrayList<Vaca> listaDeVacasQueDaoLeite = new ArrayList<>();


    public Fazenda(String nomeDaFazenda) {
        this.nomeFazenda = nomeDaFazenda;
        System.out.println("Dia " + this.dia + " fazenda " + this.nomeFazenda + " criada, você tem " + this.caixa
                + " reais para investir na sua fazenda");
    }
    public Fazenda() {

    }
    public double getQuantidadeDeLeitePorLitro() {
        return quantidadeDeLeitePorLitro;
    }
    public ArrayList<Empregado> getListaDeEmpregados() {
        return listaDeEmpregados;
    }
    public double getCaixa() {
        return caixa;
    }

    public void adicionarAoCaixa(double valor) {
        this.caixa += valor;
    }
    public void retirarDoCaixa(double valor){
        this.caixa -= valor;
    }
    public void adicionarLeite(double valor) {
        this.quantidadeDeLeitePorLitro += valor;
    }
    public void retirarLeite(double valor){
        this.quantidadeDeLeitePorLitro -= valor;
    }

    public ArrayList<Derivado> getListaDeDerivados() {
        return listaDeDerivados;
    }


    public ArrayList<Loja> getListaDeLoja() {
        return listaDeLoja;
    }

    public ArrayList<Pasto> getListaDePasto() {
        return listaDePasto;
    }

    public ArrayList<Vaca> getListaDeVacas() {
        return listaDeVacas;
    }
    public int getVacaIdentificacao() {
        return vacaIdentificacao;
    }
    public int getPastoIdentificacao() {
        return pastoIdentificacao;
    }

    public void contrataEmpregado(Empregado empregado) {
        listaDeEmpregados.add(empregado);
        System.out.println("Empregado " + empregado.getNome() + " contratado");
    }

    public void comprarPasto(Pasto pasto,double tamanhoPorMetroQuadrado) {
        this.listaDePasto.add(pasto);
        pasto.identificacaoPasto = this.pastoIdentificacao;
        this.pastoIdentificacao ++;
        pasto.tamanho = tamanhoPorMetroQuadrado;
        double refCustoDoPasto = tamanhoPorMetroQuadrado * pasto.valorDeTamanhoPorMetroQuadrado;
        this.retirarDoCaixa(refCustoDoPasto);
        System.out.println("Pasto de " + refCustoDoPasto + " reais, com " + pasto.tamanho +  " m² comprado, você tem " + this.caixa);
    }
    public void comprarLoja(Loja loja, int tamanhoDoEstoque) {
        this.listaDeLoja.add(loja);
        loja.identificacaoLoja = this.lojaIdentificacao;
        this.lojaIdentificacao ++;
        loja.tamanhoDoEstoque = tamanhoDoEstoque;
        double refCustoDaLoja = tamanhoDoEstoque * loja.valorPorCadaEspacoNoEstoque;
        this.retirarDoCaixa(refCustoDaLoja);
        loja.caixa = this.caixa;
        System.out.println("loja de " + refCustoDaLoja + " reais, com " + loja.tamanhoDoEstoque +  " espaços de estoque comprada, você tem " + this.caixa);
    }
    public void comprarVaca(Vaca vaca,Pasto pasto) {
        if (vaca.getEspacoNecessarioPorMetroQuadrado() <= pasto.tamanho) {
            //adiciona a vaca na listaDeVacas
            this.listaDeVacas.add(vaca);
            this.listaDeVacasQueDaoLeite.add(vaca);
            this.retirarDoCaixa(vaca.getValorDeCompra());
            //da a vaca a identificação e incrementa mais um na vacaIdentificacao
            vaca.setIdentificacaoVaca(this.vacaIdentificacao);
            this.vacaIdentificacao++;
            pasto.tamanho -= vaca.getEspacoNecessarioPorMetroQuadrado();
            System.out.println("Vaca " + vaca.getIdentificacaoVaca() + " custando: " + vaca.getValorDeCompra() + " comprada, você tem: "
                    + this.listaDeVacas.toArray().length + " vacas e " + this.caixa + " reais, sua lista de vacas é: " + this.listaDeVacas);
        } else {
            System.out.println("O pasto não tem espaço suficiente para comprar esta vaca ");
        }
    }

    public void proximoDia() {
        this.dia ++;
        this.contagemDeMes++;
        System.out.println("Bom dia, hoje é seu: " + this.dia + "º dia ");

        //CODIGO QUE FAZ O PAGAMENTO DOS EMPREGADOS A CADA 30 DIAS DE ACORDO COM A CONTAGEMDEMES
        double valorTotalParaPagamentoDosEmpregados = 0;
        if (this.contagemDeMes == 30 ) {
            for (int i = 0; i < this.listaDeEmpregados.toArray().length; i++) {
                valorTotalParaPagamentoDosEmpregados += this.listaDeEmpregados.get(i).getSalarioPorMes();
                System.out.println("empregado " + this.listaDeEmpregados.get(i).getNome() + " recebeu o salario");
            }
            System.out.println("valor total a pagar aos empregados: " + valorTotalParaPagamentoDosEmpregados);
            //CODIGO RETIRA O VALORTOTALPARAPAGAMENTODOSEMPREGADOS DO CAIXA
            this.caixa -= valorTotalParaPagamentoDosEmpregados;

            //CODIGOS QUE ZERAM A CONTAGEMDEMES E VALORTOTALPARAPAGAMENTODOSEMPREGADOS ATE O PROXIMO MES
            valorTotalParaPagamentoDosEmpregados = 0;
            this.contagemDeMes = 0;
        }
        //CODIGO QUE RETORNA O VALOR DE PRODUCAODELEITEPORDIA DAS VACAS DA LISTA PARA 8
        for (int i = 0; i < this.listaDeVacas.toArray().length; i++) {
            this.listaDeVacas.get(i).setProducaoDeLeitePorDia(8);
        }
        System.out.println("Seu caixa é : " + this.caixa + " reais, a quantidade de leite é: "
                + this.quantidadeDeLeitePorLitro + " litros");
    }
}
