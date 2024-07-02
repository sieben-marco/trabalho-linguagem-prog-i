#include <stdio.h> // biblioteca padrão de I/O
#include <stdlib.h> // biblioteca padrão de C
#include <string.h> // biblioteca para tratamento de strings

void imprime_msg_inicial()
{
    printf("******************************************\n");
    printf("***      Seja bem vindo ao banco!      ***\n");
    printf("******************************************\n\n");
}

void cadastra(char nome[50], char tipo_conta[8], float* saldo)
{
    printf("FAÇA O SEU CADASTRO A SEGUIR\n\n");
    int opc_tipo_conta;

    // nome cliente
    printf("- Informe o seu nome completo: ");
    gets(nome); // entrada do fluxo de stdin

    // tipo de conta
    printf("- Tipos de conta:\n");
    printf("\t(1) - Corrente\n");
    printf("\t(2) - Poupança\n");
    printf("  Escolha sua opção: ");
    scanf("%d", &opc_tipo_conta);

    if (opc_tipo_conta == 1) {
        strcpy(tipo_conta, "Corrente");
    } else {
        strcpy(tipo_conta, "Poupança");
    }

    // depósito inicial
    printf("- Informe o valor do seu depósito inicial: R$ ");
    scanf("%f", *saldo);

    // system("cls");
}

void imprime_cabecalho(char nome[50], char tipo_conta[8], float saldo)
{
    printf("****************************************\n");
    printf("Dados iniciais do cliente:\n\n");
    printf("Nome: %s\n", nome);
    printf("Tipo da conta: %s\n", tipo_conta);
    printf("Saldo: %.2f\n", saldo);
    printf("****************************************\n\n");
}

int main()
{
    char nome[50];
    char tipo_conta[8];
    float saldo;

    imprime_msg_inicial();

    cadastra(nome, tipo_conta, &saldo);
    
    imprime_cabecalho(nome, tipo_conta, saldo);

    return 0;
}
