package cadastros;

import repository.EnfermeirosRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Enfermeiro extends Pessoa {
    private String formacao;
    private String cadastroCofen;

    public Enfermeiro(
            String nome,
            String genero,
            Date dob,
            String cpf,
            String telefone,
            String formacao,
            String cadastroCofen) {
        super(nome, genero, dob, cpf, telefone, EnfermeirosRepository.getNumeroDeEnfermeiros() + 1);
        this.formacao = formacao;
        this.cadastroCofen = cadastroCofen;

        EnfermeirosRepository.adicionarEnfermeiro(this);
        System.out.println("-------------------------------------------------");
        System.out.println("Enfermeiro cadastrado: ");
        System.out.println(this);
        System.out.println("-------------------------------------------------");
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return "Enfermeiro{" +
                "nome='" + nome + '\'' +
                ", id='" + id +
                ", genero='" + genero + '\'' +
                ", dob=" + formatter.format(dob) +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", formacao='" + formacao + '\'' +
                ", cadastroCofen='" + cadastroCofen + '\'' +
                '}';
    }
}
