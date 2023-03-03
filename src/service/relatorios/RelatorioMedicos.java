package service.relatorios;

import cadastros.Medico;
import cadastros.enums.Especializacao;
import repository.MedicosRepository;
import service.cadastros.CadastroHelpers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RelatorioMedicos {
    public static void gerarMenu() {
        System.out.println("--------------------------------------");
        System.out.println("Medicos de qual especialidade devem ser listados?");
        System.out.println();
        System.out.println("1. Clínico geral");
        System.out.println("2. Anestesista");
        System.out.println("3. Dermatologista");
        System.out.println("4. Ginecologista");
        System.out.println("5. Neurologista");
        System.out.println("6. Pediatra");
        System.out.println("7. Psiquiatra");
        System.out.println("8. Ortopedista");
        System.out.println("9. Todos");
        System.out.println("Selecione o número da opção desejada: ");

        try {
            Scanner scanner = new Scanner(System.in);

            int opcao = scanner.nextInt();

            if (opcao < 0 || opcao > 9) {
                throw new IllegalArgumentException();
            }

            gerarRelatorioDeMedicos(opcao);
        } catch (IllegalArgumentException | InputMismatchException e) {
            CadastroHelpers.printError("Selecione a opção através de um número entre '1' e '9'.");
            gerarMenu();
        }
    }

    private static void gerarRelatorioDeMedicos(int opcao) {
        List<Medico> listaFiltrada = switch (opcao) {
            case 1 -> filtraListaDeMedicos(Especializacao.CLINICO_GERAL);
            case 2 -> filtraListaDeMedicos(Especializacao.ANESTESISTA);
            case 3 -> filtraListaDeMedicos(Especializacao.DERMATOLOGIA);
            case 4 -> filtraListaDeMedicos(Especializacao.GINECOLOGIA);
            case 5 -> filtraListaDeMedicos(Especializacao.NEUROLOGIA);
            case 6 -> filtraListaDeMedicos(Especializacao.PEDIATRIA);
            case 7 -> filtraListaDeMedicos(Especializacao.PSIQUIATRIA);
            case 8 -> filtraListaDeMedicos(Especializacao.ORTOPEDIA);
            default -> MedicosRepository.getMedicosCadastrados();
        };

        if (listaFiltrada.size() == 0) {
            System.out.println("------------------------------------");
            System.out.println("Sistema não possui médicos cadastrados com esta especialidade!");
            System.out.println("------------------------------------");
            return;
        }

        System.out.println("Médicos: ");
        for (Medico medico : listaFiltrada) {
            System.out.println("------------------------------------");
            System.out.println("Código: " + medico.getId());
            System.out.println("Nome: " + medico.getNome());
            System.out.println("Instituição: " + medico.getFormacao());
            System.out.println("CRM: " + medico.getCadastroCrm());
            System.out.println("Especialização: " + medico.getEspecializacao());
        }
    }

    private static List<Medico> filtraListaDeMedicos(Especializacao especializacao) {
        List<Medico> medicos = MedicosRepository.getMedicosCadastrados();
        List<Medico> listaFiltrada = new ArrayList<>();

        for (Medico medico : medicos) {
            if (medico.getEspecializacao() == especializacao) {
                listaFiltrada.add(medico);
            }
        }

        return listaFiltrada;
    }
}
