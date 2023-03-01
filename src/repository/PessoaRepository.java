package repository;

import cadastros.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {
    static public List<Pessoa> getTodasPessoas() {
        List<Pessoa> listaAtualizada = new ArrayList<>();

        listaAtualizada.addAll(EnfermeirosRepository.getEnfermeirosCadastrados());
        listaAtualizada.addAll(MedicosRepository.getMedicosCadastrados());
        listaAtualizada.addAll(PacientesRepository.getPacientesCadastrados());

        return listaAtualizada;
    }
}
