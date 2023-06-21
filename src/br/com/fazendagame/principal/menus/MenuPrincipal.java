package br.com.fazendagame.principal.menus;

public class MenuPrincipal {
    //MENU PRINCIPAL
    public static void exibirMenuPrincipal() {
        //MENU PRINCIPAL
        System.out.println("""
                                ***MENU PRINCIPAL***
                    1.Ir para fazenda 2.Ir para pasto 3.Ir para loja 4.Ir para proximo dia
                    \s""");
    }

        //MENU FAZENDA
    public static void exibirMenuFazenda() {
        System.out.println("""
                                ***MENU FAZENDA***
                    1.Contratar empregado 2.Aumentar tamanho do pasto 3.Comprar loja 4.Comprar vaca
                    \s""");
        //futuramente implantar demisao de empregado, venda de pasto, loja e vaca
    }

    public static void exibirMenuPasto() {
        System.out.println("""
                                ***MENU PASTO***
                    1.Produzir leite 2.Produzir derivados 3. Proximo dia
                    \s""");
    }

    public static void exibirMenuLoja() {
        System.out.println("""
                                ***MENU LOJA***
                    1.Vender derivados 2.ver lista de derivados 3.
                    \s""");
    }


}
