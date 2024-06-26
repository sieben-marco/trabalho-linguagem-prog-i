import java.util.Scanner;

public class Main {
    public static void imprimeCabecalho(String nome, double[] saldo)
    {
        System.out.printf("""
                ****************************************
                 Dados iniciais do cliente:

                 Nome:       %s
                 Tipo conta: Corrente
                 Saldo:      %.2f

                ****************************************

                """, nome, saldo[0]
        );
    }

    public static int exibeOperacoes()
    {
        Scanner in = new Scanner(System.in);

        // "Receber valor" não é uma opção real, pode ser outra opção!
        System.out.print("""
                Operações

                1- Consultar saldo
                2- Receber valor
                3- Transferir valor
                4- Sair

                Digite a opção desejada:\s"""
        );

        return in.nextInt();
    }

    public static void executaOperacao(int opcao, double[] saldo)
    {
        switch (opcao) {
            case 1 -> System.out.printf("O seu saldo é R$ %.2f\n\n", saldo[0]);
            case 2, 3 -> defineQtde(opcao, saldo); // chama função que define a qtde e o tipo da tarefa
        }
    }

    private static void defineQtde(int opcao, double[] saldo)
    {
        Scanner in = new Scanner(System.in);
        String tipoOperacao = "";

        switch (opcao) {
            case 2 -> tipoOperacao = "receber";
            case 3 -> tipoOperacao = "transferir";
        }

        System.out.printf("Informe o valor a %s: ", tipoOperacao);
        double valorOperacao = in.nextDouble();

        switch (opcao) {
            case 2 -> recebeValor(saldo, valorOperacao);
            case 3 -> transfereValor(saldo, valorOperacao);
        }
    }

    private static void recebeValor(double[] saldo, double valorOperacao)
    {
        saldo[0] += valorOperacao;
    }

    private static void transfereValor(double[] saldo, double valorOperacao)
    {
        saldo[0] -= valorOperacao;
    }

    // FUNÇÃO PRINCIPAL
    public static void main(String[] args)
    {
        // fazer processo de cadastro
        String nome = "Marco Sieben";
        double[] saldo = { 2500.00 };

        imprimeCabecalho(nome, saldo); // imprime o extrato

        int opcao = 0;

        // loop de opções, até usuário encerrar a execução
        while (opcao > -1 && opcao < 4) {
            opcao = exibeOperacoes(); // chama a função exibindo as opções e lendo a escolha do usuário
                                      // se a entrada for 0 (zero) continua dentro do loop, mas deveria sair!
            executaOperacao(opcao, saldo); // executa escolha do usuário (** é necessário executar se a escolha for para sair? **)
        }

        System.out.println("Saindo do programa."); // informação de encerramento
    }
}
