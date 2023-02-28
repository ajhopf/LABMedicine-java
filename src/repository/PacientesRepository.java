package repository;

import cadastros.Paciente;

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

}
