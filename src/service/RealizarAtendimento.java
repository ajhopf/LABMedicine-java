package service;

import cadastros.Medico;
import cadastros.Paciente;
import cadastros.enums.StatusAtendimento;
import repository.MedicosRepository;
import repository.PacientesRepository;
import service.cadastros.CadastroHelpers;

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

        Medico medico = obterMedico();

        if (!medico.isActive()) {
            System.out.println("Médico selecionado está inativo. Atendimento não realizado.");
            System.out.println("----------------------------");
            return;
        }

        Paciente paciente = obterPaciente();

        medico.realizarAtendimento();
        paciente.realizarAtendimento();
        System.out.println("Atendimento realizado com sucesso!");
        System.out.println("----------------------------");
    }

    static private Medico obterMedico() {
        Medico medico = null;
        boolean encontrouMedico = false;
        while (!encontrouMedico) {
            try {
                int medicoId = obterMedicoId();
                medico = MedicosRepository.getMedicosCadastrados().get(medicoId - 1);
                System.out.println("Nome do médico: " + medico.getNome());
                encontrouMedico = true;
            } catch (IndexOutOfBoundsException e) {
                CadastroHelpers.printError("Médico não encontrado!");
            } catch (InputMismatchException e) {
                CadastroHelpers.printError("O id deve ser um número.");
            }
        }

        return medico;
    }

    static private int obterMedicoId(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o id do médico: ");
        return scanner.nextInt();
    }

    static private Paciente obterPaciente() {
        Paciente paciente = null;
        boolean encontrouPaciente = false;
        while (!encontrouPaciente) {
            try {
                int pacienteId = obterPacienteId();
                paciente = PacientesRepository.getPacientesCadastrados().get(pacienteId - 1);
                System.out.println("Nome do paciente: " + paciente.getNome());
                paciente.setStatusAtendimento(StatusAtendimento.EM_ATENDIMENTO);
                encontrouPaciente = true;
            } catch (IndexOutOfBoundsException e) {
                CadastroHelpers.printError("Paciente não encontrado!");
            } catch (InputMismatchException e) {
                CadastroHelpers.printError("O id deve ser um número.");
            }
        }

        return paciente;
    }

    static private int obterPacienteId(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o id do paciente: ");
        return scanner.nextInt();
    }




}
