package repository;

import cadastros.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {
    static private final List<Pessoa> pessoasCadastradas = new ArrayList<>();

    static public void adicionarPessoa(Pessoa pessoa) {
        pessoasCadastradas.add(pessoa);
    }

    static public List<Pessoa> verPessoasCadastradas() {
        return pessoasCadastradas;
    }

    static public int retornaNumeroDeCadastros(){
        return pessoasCadastradas.size();
    }
}
