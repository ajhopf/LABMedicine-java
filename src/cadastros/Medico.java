package cadastros;

import cadastros.enums.Especializacao;
import repository.MedicosRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Medico extends Pessoa {
    private String formacao;
    private String cadastroCrm;
    private Especializacao especializacao;
    private boolean isActive;
    private int atendimentosRealizados;

    public Medico(String nome, String genero, Date dob, String cpf, String telefone, String formacao, String cadastroCrm, Especializacao especializacao, boolean isActive) {
        super(nome, genero, dob, cpf, telefone, MedicosRepository.getNumeroDeMedicos() + 1);
        this.formacao = formacao;
        this.cadastroCrm = cadastroCrm;
        this.especializacao = especializacao;
        this.isActive = isActive;
        this.atendimentosRealizados = 0;

        MedicosRepository.adicionarMedico(this);

        System.out.println("-------------------------------------------------");
        System.out.println("Médico cadastrado: ");
        System.out.println(this);
        System.out.println("-------------------------------------------------");
    }

    public void realizarAtendimento() {
        atendimentosRealizados++;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getCadastroCrm() {
        return cadastroCrm;
    }

    public void setCadastroCrm(String cadastroCrm) {
        this.cadastroCrm = cadastroCrm;
    }

    public Especializacao getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Especializacao especializacao) {
        this.especializacao = especializacao;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getAtendimentosRealizados() {
        return atendimentosRealizados;
    }

    public void setAtendimentosRealizados(int atendimentosRealizados) {
        this.atendimentosRealizados = atendimentosRealizados;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return "Medico{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", dob=" + formatter.format(dob) +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", formacao='" + formacao + '\'' +
                ", cadastroCrm='" + cadastroCrm + '\'' +
                ", especializacao=" + especializacao +
                ", isActive=" + isActive +
                ", atendimentosRealizados=" + atendimentosRealizados +
                ", id=" + id +
                '}';
    }
}
