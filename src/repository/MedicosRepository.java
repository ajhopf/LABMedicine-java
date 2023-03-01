package repository;

import cadastros.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicosRepository {
    static private List<Medico> medicosCadastrados = new ArrayList<>();
    static public void adicionarMedico(Medico medico) {
        medicosCadastrados.add(medico);
    }

    static public List<Medico> getMedicosCadastrados() {
        return medicosCadastrados;
    }

    static public int getNumeroDeMedicos() {
        return medicosCadastrados.size();
    }

}
