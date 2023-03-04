package navegacao;

import service.*;
import service.cadastros.CadastroEnfermeiro;
import service.cadastros.CadastroHelpers;
import service.cadastros.CadastroMedico;
import service.cadastros.CadastroPaciente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelaInicial {
    public static void iniciar() {
        try {
            gerarMenuInicial();
            int opcaoSelecionada = capturarInput();

            if (opcaoSelecionada < 0 || opcaoSelecionada > 6 ) {
                throw new IllegalArgumentException();
            }

            switch (opcaoSelecionada) {
                case 0:
                    System.out.println("Até logo!");
                    return;
                case 1:
                    CadastroPaciente.cadastrarPaciente();
                    break;
                case 2:
                    CadastroEnfermeiro.cadastrarEnfermeiro();
                    break;
                case 3:
                    CadastroMedico.cadastrarMedico();
                    break;
                case 4:
                    RealizarAtendimento.realizarAtendimento();
                    break;
                case 5:
                    AtualizarStatusDePaciente.atualizarStatus();
                    break;
                case 6:
                    TelaRelatorios.gerarRelatorios();
                    break;
                default: System.out.println("Você escolheu a opção " + opcaoSelecionada);
            }

            iniciar();
        } catch (IllegalArgumentException e) {
            CadastroHelpers.printError("Você deve selecionar um número entre 1 e 6.");
            iniciar();
        } catch (InputMismatchException e){
            CadastroHelpers.printError("A opção deve ser selecionada através de um número.");
            iniciar();
        }
        catch (Exception e) {
            CadastroHelpers.printError(e.toString());
            iniciar();
        }
    }

    private static int capturarInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void gerarMenuInicial(){
        System.out.println("Bem vindo ao sistema iMedical!");
        System.out.println();
        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("1. Cadastro de Paciente");
        System.out.println("2. Cadastro de Enfermeiro");
        System.out.println("3. Cadastro de Médico");
        System.out.println("4. Realizar Atendimento Médico");
        System.out.println("5. Atualizar o Status de Atendimento do Paciente");
        System.out.println("6. Relatórios");
        System.out.println("0. Sair do Sistema");
        System.out.println("-------------------");
        System.out.print("Selecione o número da opção desejada: ");
    }

}
