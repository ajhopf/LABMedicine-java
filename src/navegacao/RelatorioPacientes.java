package navegacao;

import cadastros.Paciente;
import cadastros.enums.StatusAtendimento;
import repository.PacientesRepository;
import service.CadastroHelpers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RelatorioPacientes {
    public static void gerarMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Pacientes com qual status de atendimento devem ser listados?");
        System.out.println("1. Aguardando atendimento");
        System.out.println("2. Em atendimento");
        System.out.println("3. Atendido");
        System.out.println("4. Não atendido");
        System.out.println("5. Todos");
        System.out.println("Selecione o número da opção desejada: ");

        try {
            Scanner scanner = new Scanner(System.in);

            int opcao = scanner.nextInt();

            if (opcao < 0 || opcao > 5) {
                throw new IllegalArgumentException();
            }

            gerarRelatorioDePacientes(opcao);
        } catch (IllegalArgumentException | InputMismatchException e) {
            CadastroHelpers.printError("Selecione a opção através de um número entre '1' e '4'.");
            gerarMenu();
        }
    }

    private static void gerarRelatorioDePacientes(int opcao) {
        List<Paciente> listaFiltrada = null;

        switch (opcao) {
            case 1:
                listaFiltrada = filtraListaDePacientes(StatusAtendimento.AGUARDANDO_ATENDIMENTO);
                break;
            case 2:
                listaFiltrada = filtraListaDePacientes(StatusAtendimento.EM_ATENDIMENTO);
                break;
            case 3:
                listaFiltrada = filtraListaDePacientes(StatusAtendimento.ATENDIDO);
                break;
            case 4:
                listaFiltrada = filtraListaDePacientes(StatusAtendimento.NAO_ATENDIDO);
                break;
            default:
                listaFiltrada = PacientesRepository.getPacientesCadastrados();
        }

        if (listaFiltrada.size() == 0) {
            System.out.println("------------------------------------");
            System.out.println("Sistema não possui pacientes cadastrados com este status de atendimento!");
        }


        for (Paciente paciente : listaFiltrada) {
            System.out.println("------------------------------------");
            System.out.println("Código: " + paciente.getId());
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("Convênio: " + paciente.getConvenio());
            System.out.println("Total de atendimentos: " + paciente.getAtendimentosRealizados());
        }
        System.out.println("------------------------------------");
    }

    private static List<Paciente> filtraListaDePacientes(StatusAtendimento status) {
        List<Paciente> pacientes = PacientesRepository.getPacientesCadastrados();
        List<Paciente> listaFiltrada = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            if (paciente.getStatusAtendimento() == status) {
                listaFiltrada.add(paciente);
            }
        }

        return listaFiltrada;
    }
}
