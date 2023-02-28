package cadastros;

import repository.PessoaRepository;

import java.util.Date;

public class Enfermeiro extends Pessoa {
    private String formacao;
    private String cadastroCofen;

    public Enfermeiro(String nome, String genero, Date dob, String cpf, String telefone, String formacao, String cadastroCofen) {
        super(nome, genero, dob, cpf, telefone, PessoaRepository.retornaNumeroDeCadastros() + 1);
        this.formacao = formacao;
        this.cadastroCofen = cadastroCofen;

        PessoaRepository.adicionarPessoa(this);
    }

    public String getNome(){
        return super.nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getCadastroCofen() {
        return cadastroCofen;
    }

    public void setCadastroCofen(String cadastroCofen) {
        this.cadastroCofen = cadastroCofen;
    }

    @Override
    public String toString() {
        return "Enfermeiro{" +
                "nome='" + nome + '\'' +
                ", id='" + id +
                ", genero='" + genero + '\'' +
                ", dob=" + dob +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", formacao='" + formacao + '\'' +
                ", cadastroCofen='" + cadastroCofen + '\'' +
                '}';
    }
}
