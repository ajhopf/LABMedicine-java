import cadastros.Enfermeiro;
import cadastros.Medico;
import cadastros.Paciente;
import cadastros.enums.Especializacao;
import cadastros.enums.StatusAtendimento;
import navegacao.TelaInicial;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> alergias = new ArrayList<>();
        alergias.add("formiga");
        alergias.add("ibuprofeno");
        List<String> cuidadosEspecificos = new ArrayList<>();

        Paciente paciente = new Paciente(
                "André Hopf",
                "masculino",
                new Date(1992, Calendar.MARCH,14),
                "022.567.470-00",
                "(48) 999030959",
                "Andre",
                alergias,
                cuidadosEspecificos,
                "Unimed",
                "1234",
                new Date(),
                StatusAtendimento.AGUARDANDO_ATENDIMENTO
        );

        Paciente paciente2 = new Paciente(
                "Rachel Lunardi",
                "feminino",
                new Date(1993, Calendar.MARCH,29),
                "022.567.470-00",
                "(48) 999030959",
                "Andre",
                alergias,
                cuidadosEspecificos,
                "Unimed",
                "1234",
                new Date(),
                StatusAtendimento.AGUARDANDO_ATENDIMENTO
        );

        Medico medico = new Medico(
                "Lucas Hopf",
                "masculino",
                new Date(1995, Calendar.MARCH, 29),
                "123.123.123-00",
                "98989898",
                "UFRGS",
                "1234/RS",
                Especializacao.ORTOPEDIA,
                true
        );

        Enfermeiro enfermeiro = new Enfermeiro(
                "Fatima Lunardi",
                "feminino",
                new Date(1960, Calendar.AUGUST, 12),
                "111.222.333-44",
                "(48)98989898",
                "UFSC",
                "1234/SC"
        );

        TelaInicial.iniciar();
    }
}