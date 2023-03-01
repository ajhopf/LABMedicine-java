package navegacao;

public enum MenuTelaInicial {
    CADASTRO_PACIENTE(1),
    CADASTRO_ENFERMEIRO(2),
    CADASTRO_MEDICO(3),
    ATENDIMENTO(4),
    ATUALIZAR_STATUS(5),
    RELATORIOS(6);

    private Integer codigo;

    private MenuTelaInicial(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
