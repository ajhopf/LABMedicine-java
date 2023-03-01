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
}
