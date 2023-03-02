package cadastros;

import java.util.Date;

public abstract class Pessoa {
    protected int id;
    protected String nome;
    protected String genero;
    protected Date dob;
    protected String cpf;
    protected String telefone;

    public Pessoa(String nome, String genero, Date dob, String cpf, String telefone, int id) {
        this.nome = nome;
        this.genero = genero;
        this.dob = dob;
        this.cpf = cpf;
        this.telefone = telefone;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
