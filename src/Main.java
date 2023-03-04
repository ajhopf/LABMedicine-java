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


    }
}