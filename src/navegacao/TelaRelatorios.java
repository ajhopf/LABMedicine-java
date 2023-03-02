package navegacao;

import service.CadastroHelpers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaRelatorios {
    public static void gerarRelatorios() {
        gerarMenuRelatorios();
        int opcao = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            if (opcao < 1 || opcao > 3) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException | InputMismatchException e) {
            CadastroHelpers.printError("Selecione a opção através de um número entre '1' e '3'.");
            gerarRelatorios();
        }

        switch (opcao) {
            case 1:
                ListagemPessoas.gerarMenuDePessoas();
                break;
            case 2:
                RelatorioPacientes.gerarMenu();
                break;
            case 3:
                System.out.println("Relatório dos Médicos");
                break;
            default:
                System.out.println("hello!");
        }

    }

    private static void gerarMenuRelatorios(){
        System.out.println("--------------------------------------");
        System.out.println("Selecione a opção desejada para gerar os relatórios:");
        System.out.println();
        System.out.println("1. Listagem de Pessoas");
        System.out.println("2. Relatório dos Pacientes");
        System.out.println("3. Relatório dos Médicos");
        System.out.println("Selecione o número da opção desejada: ");
    }
}
