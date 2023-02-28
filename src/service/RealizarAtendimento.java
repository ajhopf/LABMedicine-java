package service;

import cadastros.Medico;
import cadastros.Paciente;
import cadastros.enums.StatusAtendimento;
import repository.MedicosRepository;
import repository.PacientesRepository;

import java.util.Scanner;

public class RealizarAtendimento {
    static public void realizarAtendimento() {
        System.out.println("Realizar Atendimento");

        int medicoId = getMedicoId();
        int pacienteId = getPacienteId();

        Medico medico = MedicosRepository.getMedicosCadastrados().get(medicoId - 1);
        medico.realizarAtendimento();

        Paciente paciente = PacientesRepository.getPacientesCadastrados().get(pacienteId - 1);
        paciente.realizarAtendimento();
        paciente.setStatusAtendimento(StatusAtendimento.EM_ATENDIMENTO);
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
