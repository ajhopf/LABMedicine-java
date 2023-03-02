package cadastros;

import cadastros.enums.StatusAtendimento;
import repository.PacientesRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Paciente extends Pessoa {
    private String contatoEmergencia;
    private List<String> alergias;
    private List<String> cuidadosEspecificos;
    private String convenio;
    private String numeroConvenio;
    private Date validadeConvenio;
    private StatusAtendimento statusAtendimento;
    private int atendimentosRealizados = 0;

    public Paciente(
            String nome, String genero, Date dob, String cpf, String telefone,
            String contatoEmergencia,
            List<String> alergias,
            List<String> cuidadosEspecificos,
            String convenio, String numeroConvenio,
            Date validadeConvenio,
            StatusAtendimento statusAtendimento) {
        super(nome, genero, dob, cpf, telefone, PacientesRepository.getNumeroDePacientes() + 1);
        this.contatoEmergencia = contatoEmergencia;
        this.alergias = alergias;
        this.cuidadosEspecificos = cuidadosEspecificos;
        this.convenio = convenio;
        this.numeroConvenio = numeroConvenio;
        this.validadeConvenio = validadeConvenio;
        this.statusAtendimento = statusAtendimento;

        PacientesRepository.adicionarPaciente(this);

        System.out.println("Paciente adicionado com sucesso");
        System.out.println(this);
    }

    public void realizarAtendimento() {
        atendimentosRealizados++;
    }


    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public List<String> getCuidadosEspecificos() {
        return cuidadosEspecificos;
    }

    public void setCuidadosEspecificos(List<String> cuidadosEspecificos) {
        this.cuidadosEspecificos = cuidadosEspecificos;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public Date getValidadeConvenio() {
        return validadeConvenio;
    }

    public void setValidadeConvenio(Date validadeConvenio) {
        this.validadeConvenio = validadeConvenio;
    }

    public StatusAtendimento getStatusAtendimento() {
        return statusAtendimento;
    }

    public void setStatusAtendimento(StatusAtendimento statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
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

        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", dob=" + formatter.format(dob) +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", contatoEmergencia='" + contatoEmergencia + '\'' +
                ", alergias=" + alergias +
                ", cuidadosEspecificos=" + cuidadosEspecificos +
                ", convenio='" + convenio + '\'' +
                ", numeroConvenio=" + numeroConvenio +
                ", validadeConvenio=" + formatter.format(validadeConvenio) +
                ", statusAtendimento=" + statusAtendimento +
                ", atendimentosRealizados=" + atendimentosRealizados +
                ", id=" + id +
                '}';
    }
}
