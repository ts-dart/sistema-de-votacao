package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe para executar o sitema de votação.
 */
public class Principal {

  /**
   * Método principal da classe para execução do programa.
   *
   * @param args não usado.
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Scanner sc = new Scanner(System.in);

    String nome;
    String cpf;
    short resp;
    int numero;

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      resp = sc.nextShort();

      if (resp == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        nome = sc.next();
        System.out.println("Entre com o número da pessoa candidata:");
        numero = sc.nextInt();
        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      }
    } while (resp == 1);

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      resp = sc.nextShort();

      if (resp == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        nome = sc.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        cpf = sc.next();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      }
    } while (resp == 1);

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      resp = sc.nextShort();

      if (resp == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        cpf = sc.next();
        System.out.println("Entre com o número da pessoa candidata:");
        numero = sc.nextShort();
        gerenciamentoVotacao.votar(cpf, numero);
      } else if (resp == 2) {
        gerenciamentoVotacao.mostrarResultado();
      }
    } while (resp != 3);
    gerenciamentoVotacao.mostrarResultado();
  }
}
