package service;

import cadastros.Paciente;
import cadastros.enums.StatusAtendimento;
import repository.PacientesRepository;

public class AtualizarStatusDePaciente {
    static public StatusAtendimento atualizarStatus(StatusAtendimento novoStatus, int pacienteId) {
        Paciente paciente = PacientesRepository.getPacientesCadastrados().get(pacienteId - 1);

        paciente.setStatusAtendimento(novoStatus);

        return paciente.getStatusAtendimento();
    }
}
