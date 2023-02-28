package repository;

import cadastros.Paciente;
import cadastros.enums.StatusAtendimento;

import java.util.ArrayList;
import java.util.List;

public class PacientesRepository {
    static private List<Paciente> pacientesCadastrados = new ArrayList<>();
    static public void adicionarPaciente(Paciente paciente) {
        pacientesCadastrados.add(paciente);
    }

    static public List<Paciente> getPacientesCadastrados() {
        return pacientesCadastrados;
    }

    static public int getNumeroDePacientes() {
        return pacientesCadastrados.size();
    }

    static public StatusAtendimento atualizarStatus(StatusAtendimento novoStatus, int pacienteId) {
        Paciente paciente = pacientesCadastrados.get(pacienteId - 1);

        paciente.setStatusAtendimento(novoStatus);

        return paciente.getStatusAtendimento();
    }

}
