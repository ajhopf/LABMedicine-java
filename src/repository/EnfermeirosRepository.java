package repository;

import cadastros.Enfermeiro;

import java.util.ArrayList;
import java.util.List;

public class EnfermeirosRepository {
    static private List<Enfermeiro> enfermeirosCadastrados = new ArrayList<>();
    static public void adicionarEnfermeiro(Enfermeiro enfermeiro) {
        enfermeirosCadastrados.add(enfermeiro);
    }

    static public List<Enfermeiro> getEnfermeirosCadastrados() {
        return enfermeirosCadastrados;
    }

    static public int getNumeroDeEnfermeiros() {
        return enfermeirosCadastrados.size();
    }
}
