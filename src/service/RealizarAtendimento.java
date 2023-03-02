package service;

import cadastros.Medico;
import cadastros.Paciente;
import cadastros.enums.StatusAtendimento;
import repository.MedicosRepository;
import repository.PacientesRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RealizarAtendimento {
    static public void realizarAtendimento() {
        if (MedicosRepository.getMedicosCadastrados().size() == 0 || PacientesRepository.getPacientesCadastrados().size() ==0 ){
            System.out.println("----------------------------");
            System.out.println("Para realizar um atendimento é necessário que ao menos um médico e um paciente estejam cadastrados.");
            System.out.println("----------------------------");
            return;
        }

        System.out.println("Realizar Atendimento");

        boolean encontrouMedico = false;
        boolean encontrouPaciente = false;

        while (!encontrouMedico) {
            try {
                int medicoId = getMedicoId();
                Medico medico = MedicosRepository.getMedicosCadastrados().get(medicoId - 1);
                System.out.println("Nome do médico: " + medico.getNome());
                medico.realizarAtendimento();
                encontrouMedico = true;
            } catch (IndexOutOfBoundsException e) {
                CadastroHelpers.printError("Médico não encontrado!");
            } catch (InputMismatchException e) {
                CadastroHelpers.printError("O id deve ser um número.");
            }
        }

        while (!encontrouPaciente) {
            try {
                int pacienteId = getPacienteId();
                Paciente paciente = PacientesRepository.getPacientesCadastrados().get(pacienteId - 1);
                System.out.println("Nome do paciente: " + paciente.getNome());
                paciente.realizarAtendimento();
                paciente.setStatusAtendimento(StatusAtendimento.EM_ATENDIMENTO);
                encontrouPaciente = true;
            } catch (IndexOutOfBoundsException e) {
                CadastroHelpers.printError("Paciente não encontrado!");
            } catch (InputMismatchException e) {
                CadastroHelpers.printError("O id deve ser um número.");
            }
        }
    }

    static private int getMedicoId(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o id do médico: ");
        return scanner.nextInt();
    }

    static private int getPacienteId(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o id do paciente: ");
        return scanner.nextInt();
    }
}
