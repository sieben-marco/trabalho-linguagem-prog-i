import java.util.Scanner;

public class Main {
    public static void imprimeCabecalho(String nome, double[] saldo) {
        System.out.printf("****************************************\nDados iniciais do cliente:\n\nNome:       %s\nTipo conta: Corrente\nSaldo:      %.2f\n****************************************\n\n", nome, saldo[0]);
    }

    public static int exibeOperacoes() {
        Scanner in = new Scanner(System.in);

        System.out.print("""
                Operações

                1- Consultar saldo
                2- Receber valor
                3- Transferir valor
                4- Sair

                Digite a opção desejada:\s""");

        int opcao = in.nextInt();

        return opcao;
    }

    public static void executaOperacao(int opcao, double[] saldo) {
        switch (opcao) {
            case 1 -> System.out.printf("O seu saldo é R$ %.2f\n\n", saldo[0]);
            case 2, 3 -> defineQtde(opcao, saldo);
        }
    }

    private static void defineQtde(int opcao, double[] saldo) {
        Scanner in = new Scanner(System.in);
        String tipoOperacao = "";

        switch (opcao) {
            case 2 -> tipoOperacao = "receber";
            case 3 -> tipoOperacao = "transferir";
        }

        System.out.print("Informe o valor a " + tipoOperacao + ": ");
        double valorOperacao = in.nextDouble();

        switch (opcao) {
            case 2 -> recebeValor(saldo, valorOperacao);
            case 3 -> transfereValor(saldo, valorOperacao);
        }
    }

    private static void recebeValor(double[] saldo, double valorOperacao) {
        saldo[0] += valorOperacao;
    }

    private static void transfereValor(double[] saldo, double valorOperacao) {
        saldo[0] -= valorOperacao;
    }

    public static void main(String[] args) {
        String nome = "Marco Sieben";
        double[] saldo = { 2500.00 };

        imprimeCabecalho(nome, saldo);

        int opcao = 0;
        while (opcao < 4) {
            opcao = exibeOperacoes();
            executaOperacao(opcao, saldo);
        }

        System.out.println("Saindo do programa.");
    }
}

