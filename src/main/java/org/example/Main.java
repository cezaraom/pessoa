package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pessoa pessoas[] = new Pessoa[5];

        for (int i = 0; i < pessoas.length; i++) {
            pessoas[i] = new Pessoa();

            System.out.println("Digite o nome da " + (i + 1) + "ª pessoa: ");
            String nome = sc.nextLine();
            pessoas[i].setNome(nome);
            System.out.println("Digite a idade da " + (i + 1) + "ª pessoa: ");
            int idade = sc.nextInt();
            while (idade < 0) {
                System.out.println("Idade inválida.");
                System.out.println("Digite a idade da " + (i + 1) + "ª pessoa: ");
                idade = sc.nextInt();
            }
            sc.nextLine();


            pessoas[i].setIdade(idade);

        }
        for (int i = 0; i < pessoas.length; i++) {
            System.out.println(pessoas[i].toString());
        }

        Pessoa maisVelho = pessoas[0];
        Pessoa maisNova = pessoas[0];

        calcularPessoaMaisVelha(pessoas, maisVelho);
        calcularPessoaMaisNova(pessoas, maisNova);
        calculoMediaDasIdades(pessoas);

    }

    private static void calcularPessoaMaisVelha(Pessoa[] pessoas, Pessoa maisVelho) {
        for (int i = 1; i < pessoas.length; i++) {
            if (pessoas[i].getIdade() > maisVelho.getIdade()) {
                maisVelho = pessoas[i];
            }

        }
        System.out.println(maisVelho.getNome() + " é o mais velho.");
    }

    private static void calcularPessoaMaisNova(Pessoa[] pessoas, Pessoa maisNova) {
        for (int i = 1; i < pessoas.length; i++) {
            if (pessoas[i].getIdade() < maisNova.getIdade()) {
                maisNova = pessoas[i];
            }
        }
        System.out.println(maisNova.getNome() + " é o mais nova.");
    }

    private static void calculoMediaDasIdades(Pessoa[] pessoas) {
        double somaDasIdades = 0;
        for (int i = 0; i < pessoas.length; i++) {
            somaDasIdades += pessoas[i].getIdade();
        }
        double mediaDasIdades = somaDasIdades / pessoas.length;
        System.out.println("A média das idades é: " + mediaDasIdades);
    }
}