package service;

import cadastros.Paciente;
import cadastros.enums.StatusAtendimento;
import repository.PacientesRepository;
import service.cadastros.CadastroHelpers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AtualizarStatusDePaciente {
    static public void atualizarStatus() {
        if (PacientesRepository.getPacientesCadastrados().size() == 0) {
            System.out.println("----------------------------");
            System.out.println("Para atualizar o status de atendimento é necessário que ao menos um paciente esteja cadastrado no sistema.");
            System.out.println("----------------------------");
            return;
        }

        Paciente paciente = obterPaciente();
        StatusAtendimento novoStatus = obterNovoStatus();

        setNovoStatus(novoStatus, paciente);
        System.out.println("----------------------------");
        System.out.println("Status do paciente " + paciente.getNome() + " atualizado.");
        System.out.println("Novo status: " + paciente.getStatusAtendimento());
        System.out.println("----------------------------");
    }

    static private Paciente obterPaciente() {
        Paciente paciente = null;

        boolean idValido = false;
        while (!idValido) {
            try {
                System.out.println("----------------------------");
                System.out.println("Atualizar Status de Atendimento do Paciente.");
                System.out.println();

                Scanner scanner = new Scanner(System.in);

                System.out.println("Digite o id do paciente: ");
                int pacienteId = scanner.nextInt();
                paciente = PacientesRepository.getPacientesCadastrados().get(pacienteId - 1);
                System.out.println("Nome do paciente: " + paciente.getNome());
                System.out.println("Status atual do paciente: " + paciente.getStatusAtendimento());
                System.out.println("----------------------------");
                idValido = true;
            } catch (IndexOutOfBoundsException e) {
                CadastroHelpers.printError("Paciente não encontrado!");
            } catch (InputMismatchException e) {
                CadastroHelpers.printError("O id deve ser um número.");
            }
        }

        return paciente;
    }

    static private void setNovoStatus (StatusAtendimento novoStatus, Paciente paciente) {
        paciente.setStatusAtendimento(novoStatus);
    }

    static private StatusAtendimento obterNovoStatus(){
        StatusAtendimento novoStatus = null;

        boolean opcaoValida = false;
        while(!opcaoValida) {
            try {
                System.out.println("Escolha o novo status do paciente");
                System.out.println();
                System.out.println("1. Aguardando Atendimento");
                System.out.println("2. Em atendimento");
                System.out.println("3. Atendido");
                System.out.println("4. Não atendido");

                Scanner scanner = new Scanner(System.in);
                System.out.println();
                System.out.print("Novo status: ");
                int status = scanner.nextInt();

                if (status < 1 || status > 4) {
                    throw new IllegalArgumentException();
                }

                switch (status) {
                    case 1:
                        novoStatus = StatusAtendimento.AGUARDANDO_ATENDIMENTO;
                        break;
                    case 2:
                        novoStatus = StatusAtendimento.EM_ATENDIMENTO;
                        break;
                    case 3:
                        novoStatus = StatusAtendimento.ATENDIDO;
                        break;
                    default:
                        novoStatus = StatusAtendimento.NAO_ATENDIDO;
                }
                opcaoValida = true;
            } catch (IllegalArgumentException e) {
                CadastroHelpers.printError("Escolha uma opção entre '1' e '4'.");
            } catch (InputMismatchException e) {
                CadastroHelpers.printError("Você deve escolher um novo status através de um número entre '1' e '4'.");
            }
        }

        return novoStatus;
    }
}
