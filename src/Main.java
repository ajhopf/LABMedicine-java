import cadastros.Enfermeiro;
import cadastros.Medico;
import cadastros.Paciente;
import cadastros.Pessoa;
import cadastros.enums.Especializacao;
import cadastros.enums.StatusAtendimento;
import repository.PessoaRepository;

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
                1234,
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
                1234,
                new Date(),
                StatusAtendimento.AGUARDANDO_ATENDIMENTO
        );

        Enfermeiro enfermeiro = new Enfermeiro("Ziggy", "masculino", new Date(1992, Calendar.APRIL, 2), "123456", "(48)93989383", "Unisul", "12893-SC");
        Medico medico = new Medico("Gandhi", "masculino", new Date(1992, Calendar.APRIL, 2), "123456", "(48)94844884", "Unisul", "4545-SC", Especializacao.ORTOPEDIA, true);

        List<Pessoa> cadastros = PessoaRepository.verPessoasCadastradas();

        for (Pessoa pessoa : cadastros) {
            System.out.println(pessoa.getClass());
        }

        for (Pessoa pessoa : PessoaRepository.verPessoasCadastradas()) {
            System.out.println(pessoa);
        }
    }
}