package repository;

import cadastros.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {
    static private List<Pessoa> pessoasCadastradas = new ArrayList<>();

    static public List<Pessoa> getTodasPessoas() {
        List<Pessoa> listaAtualizada = new ArrayList<>();
        listaAtualizada.add((Pessoa) EnfermeirosRepository.getEnfermeirosCadastrados());
        listaAtualizada.add((Pessoa) MedicosRepository.getMedicosCadastrados());
        listaAtualizada.add((Pessoa) PacientesRepository.getPacientesCadastrados());

        pessoasCadastradas = listaAtualizada;
        return pessoasCadastradas;
    }
}
