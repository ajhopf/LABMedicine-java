package cadastros;

import cadastros.enums.Especializacao;
import repository.MedicosRepository;

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
    }

    public void realizarAtendimento() {
        atendimentosRealizados++;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", dob=" + dob +
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
