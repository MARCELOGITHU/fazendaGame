package br.com.fazendagame.modelos;

import br.com.fazendagame.modelos.produtoDerivadosDoLeite.Derivado;

import java.util.*;

public class Fazenda {
    private String nomeFazenda;
    private double caixa = 30000.00;
    private double quantidadeDeLeitePorLitro;
    protected int dia = 1;
    protected int contagemDeMes = 1;
    protected int vacaIdentificacao = 1;
    protected int pastoIdentificacao = 1;

    protected int lojaIdentificacao = 1;
    protected int quantidadeDeDerivadospossiveis;
    private ArrayList<Empregado> listaDeEmpregados = new ArrayList<>();
    private ArrayList<Loja> listaDeLoja = new ArrayList<>();
    private ArrayList<Pasto> listaDePasto = new ArrayList<>();

    private List<Derivado> listaDeDerivadosParaProducao = List.of(
            new Derivado("qualhada", 2, 10, 3),
            new Derivado("queijo", 5, 25, 10),
            new Derivado("requeijão", 15, 38, 15),
            new Derivado("manteiga", 25, 50, 20),
            new Derivado("cremedeleite", 38, 65, 32),
            new Derivado("leitecondensado", 50, 73, 40));
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

    public void retirarDoCaixa(double valor) {
        this.caixa -= valor;
    }

    public void adicionarLeite(double valor) {
        this.quantidadeDeLeitePorLitro += valor;
    }

    public void retirarLeite(double valor) {
        this.quantidadeDeLeitePorLitro -= valor;
    }


    public ArrayList<Loja> getListaDeLoja() {
        return listaDeLoja;
    }

    public ArrayList<Pasto> getListaDePasto() {
        return listaDePasto;
    }

    public List<Derivado> getListaDeDerivadosParaProducao() {
        return listaDeDerivadosParaProducao;
    }

    public void getListaDeDerivadosPossiveisDeProduzir() {
        int i = 0;
        int qDerivados = 0;
        for (Derivado derivado : listaDeDerivadosParaProducao) {
            if (this.caixa >= derivado.getCustoParaFazer() & this.quantidadeDeLeitePorLitro >= derivado.getLitrosDeLeiteParaProduzir()) {
                System.out.println(i + "." + derivado + " / " + derivado.getLitrosDeLeiteParaProduzir() + "L / " + derivado.getLucroDeVenda() + " R$ / " + derivado.getCustoParaFazer() + "R$");
                qDerivados++;
            }
            i++;
        }
        this.quantidadeDeDerivadospossiveis = qDerivados-1;
    }

    public boolean verificaListaDeDerivadosPossiveis() {
        List<Derivado> lista = new ArrayList<>();
        for (Derivado derivado : listaDeDerivadosParaProducao) {
            if (this.caixa >= derivado.getCustoParaFazer() & this.quantidadeDeLeitePorLitro >= derivado.getLitrosDeLeiteParaProduzir()) {
                lista.add(derivado);
            }
        }
        return !lista.isEmpty();
    }


    public ArrayList<Vaca> getListaDeVacas() {
        return listaDeVacas;
    }

    public int getVacaIdentificacao() {
        return vacaIdentificacao;
    }

    public int getQuantidadeDeDerivadospossiveis() {
        return quantidadeDeDerivadospossiveis;
    }

    public int getPastoIdentificacao() {
        return pastoIdentificacao;
    }

    public Empregado maoDeObra() {
        Random random = new Random();
        Empregado empregadoSelecionado = listaDeEmpregados.get(random.nextInt(listaDeEmpregados.size()));

        return empregadoSelecionado;
    }

    public void contrataEmpregado(Empregado empregado) {
        listaDeEmpregados.add(empregado);
        System.out.println("Empregado " + empregado.getNome() + " contratado");
    }

    public void comprarPasto(Pasto pasto, double tamanhoPorMetroQuadrado) {
        this.listaDePasto.add(pasto);
        pasto.identificacaoPasto = this.pastoIdentificacao;
        this.pastoIdentificacao++;
        pasto.tamanho = tamanhoPorMetroQuadrado;
        double refCustoDoPasto = tamanhoPorMetroQuadrado * pasto.valorDeTamanhoPorMetroQuadrado;
        this.retirarDoCaixa(refCustoDoPasto);
        System.out.println("Pasto de " + refCustoDoPasto + " reais, com " + pasto.tamanho + " m² comprado, você tem " + this.caixa);
    }

    public void comprarLoja(Loja loja) {
        this.listaDeLoja.add(loja);
        loja.identificacaoLoja = this.lojaIdentificacao;
        this.lojaIdentificacao++;
        loja.caixa = this.caixa;
        System.out.println("loja comprada, você tem " + this.caixa);
    }

    public void comprarVaca(Vaca vaca, Pasto pasto) {
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
                    + this.listaDeVacas.toArray().length + " vacas e " + this.caixa + " reais, sua lista de vacas é: " + this.listaDeVacas.size() + " vacas");
        } else {
            System.out.println("O pasto não tem espaço suficiente para comprar esta vaca ");
        }
    }

    public void resumoBens(Loja loja,Pasto pasto) {
        System.out.println(this.caixa + " reais\n" +
                this.listaDeVacas.size() + " vacas\n" +
                this.listaDeEmpregados.size() + " empregados\n" +
                this.quantidadeDeLeitePorLitro + " litros de leite\n" +
                "sua lista de derivados: " + loja.getListaDeDerivados() +
                "\n" + pasto.tamanho + "m² de pasto");

    }

    public void proximoDia() {
        this.dia++;
        this.contagemDeMes++;
        System.out.println("Bom dia, hoje é seu: " + this.dia + "º dia ");

        //CODIGO QUE FAZ O PAGAMENTO DOS EMPREGADOS A CADA 30 DIAS DE ACORDO COM A CONTAGEMDEMES
        double valorTotalParaPagamentoDosEmpregados = 0;
        if (this.contagemDeMes == 30) {
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
            if (this.listaDeVacas.get(i).getProducaoDeLeitePorDia() == 0) {
                this.listaDeVacasQueDaoLeite.add(listaDeVacas.get(i));
                this.listaDeVacas.get(i).setProducaoDeLeitePorDia(8);
            }
        }

        System.out.println("Seu caixa é : " + this.caixa +
                "\nA quantidade de leite é: " + this.quantidadeDeLeitePorLitro + " litros");
    }// ADICIONAR MAIS INFORMAÇÕES NO COMEÇO DO DIA


}
