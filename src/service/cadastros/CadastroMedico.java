package service.cadastros;

import cadastros.Medico;
import cadastros.enums.Especializacao;

import java.util.*;

public class CadastroMedico {

    public static void cadastrarMedico(){
        System.out.println("-------------------------------------------------");
        System.out.println("Cadastro de Medico");
        System.out.println();
        try {
            List<String> infos = obterInformacoes();

            new Medico(
                    infos.get(0),
                    infos.get(1),
                    CadastroHelpers.transformaStringEmData(infos.get(2)),
                    infos.get(3),
                    infos.get(4),
                    //depois de pessoa
                    infos.get(5),
                    infos.get(6),
                    obterEspecializacao(),
                    estaAtivo());
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private static List<String> obterInformacoes() {
        List<String> infos = new ArrayList<>(CadastroHelpers.obterInfosDePessoa());
        infos.add(obterInstituicaoDeEnsino());
        infos.add(obterCrm());
        return infos;
    }

    private static String obterInstituicaoDeEnsino() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Instituição de Ensino da Formação:");
        String instituicao = scanner.nextLine();

        if (instituicao.length() == 0) {
            CadastroHelpers.printError("Digite a instituição de ensino da formação.");
            obterInstituicaoDeEnsino();
        }

        return instituicao;
    }

    private static String obterCrm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CRM/UF");
        String crm = scanner.nextLine();

        if (crm.length() == 0) {
            CadastroHelpers.printError("Digite o cadastro CRM.");
            obterCrm();
        }

        return crm;
    }

    private static Especializacao obterEspecializacao() {
        System.out.println("Qual a especialização clínica do médico?");
        System.out.println("1. Clínico Geral");
        System.out.println("2. Anestesista");
        System.out.println("3. Dermatologista");
        System.out.println("4. Ginecologista");
        System.out.println("5. Neurologista");
        System.out.println("6. Pediatra");
        System.out.println("7. Psiquiatra");
        System.out.println("8. Ortopedista");

        Especializacao especializacao = null;

        try {
            Scanner scanner = new Scanner(System.in);
            int numero = scanner.nextInt();
            if (numero > 0 && numero < 9) {
                switch (numero) {
                    case 1 -> {
                        especializacao = Especializacao.CLINICO_GERAL;
                    }
                    case 2 -> {
                        especializacao = Especializacao.ANESTESISTA;
                    }
                    case 3 -> {
                        especializacao = Especializacao.DERMATOLOGIA;
                    }
                    case 4 -> {
                        especializacao = Especializacao.GINECOLOGIA;
                    }
                    case 5 -> {
                        especializacao = Especializacao.NEUROLOGIA;
                    }
                    case 6 -> {
                        especializacao = Especializacao.PEDIATRIA;
                    }
                    case 7 -> {
                        especializacao = Especializacao.PSIQUIATRIA;
                    }
                    case 8 -> {
                        especializacao = Especializacao.ORTOPEDIA;
                    }
                }
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            CadastroHelpers.printError("Digite um número entre 1 e 8.");
            obterEspecializacao();
        }

        return especializacao;
    }

    private static boolean estaAtivo() {
        Scanner scanner = new Scanner(System.in);
        String input = null;

        System.out.println("Estado do Médico no sistema:");
        System.out.println("1. Ativo");
        System.out.println("2. Inativo");

        boolean inputValido = false;

        while (!inputValido) {
            input = scanner.nextLine();

            if (Objects.equals(input, "1") || Objects.equals(input, "2")){
                inputValido = true;
            } else {
                CadastroHelpers.printError("Digite '1' para ativo e '2' para inativo.");
            }
        }

        return Objects.equals(input, "1");
    }
}
