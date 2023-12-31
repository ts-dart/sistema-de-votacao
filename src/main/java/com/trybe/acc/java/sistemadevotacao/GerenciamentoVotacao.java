package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe para o gerenciamento da votação.
 */
public class GerenciamentoVotacao {
  private final ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private final ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private final ArrayList<String> cpfComputado = new ArrayList<>();
  private int totalVotos = 0;

  /**
   * Método para cadastramento de pessoas candidatas.
   *
   * @param nome nome do candidato.
   * @param numero numero do candidato para a votação.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoaCadidata : this.pessoasCandidatas) {
      if (pessoaCadidata.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        break;
      }
    }
    this.pessoasCandidatas.add(new PessoaCandidata(nome, numero));
  }

  /**
   * Método para criação de pessoas eleitoras.
   *
   * @param nome nome do eleitor.
   * @param cpf do eleitor.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoaEleitora : this.pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        break;
      }
    }
    this.pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
  }

  /**
   * Método para computar votos nos candidatos.
   *
   * @param cpfPessoaEleitora cpf da pessoa eleitora.
   * @param numeroPessoaCandidata numero da pessoa candidata.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (this.cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata pessoaCandidata : this.pessoasCandidatas) {
        if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
          pessoaCandidata.receberVoto();
          this.cpfComputado.add(cpfPessoaEleitora);
          this.totalVotos += 1;
          break;
        }
      }
    }
  }

  /**
   * Método para exibir resultado da votação.
   */
  public void mostrarResultado() {
    if (this.totalVotos <= 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      int index = 0;
      for (PessoaCandidata pessoaCandidata : this.pessoasCandidatas) {
        System.out.print("Nome: ");
        System.out.print(pessoaCandidata.getNome());
        System.out.print(" - ");
        System.out.print(pessoaCandidata.getVotos());
        System.out.print(" votos ");
        System.out.print(" ( ");
        System.out.print(this.calcularPorcentagemVotos(index));
        System.out.print("%");
        System.out.println(" ) ");
        index += 1;
      }
      System.out.println("Total de votos: " + this.totalVotos);
    }
  }

  private double calcularPorcentagemVotos(int index) {
    int votos = this.pessoasCandidatas.get(index).getVotos();
    double res = ((double)votos / (double)this.totalVotos) * 100;
    return Math.round(res);
  }
}
