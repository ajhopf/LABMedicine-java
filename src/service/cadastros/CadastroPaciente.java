package service.cadastros;

import cadastros.Paciente;
import cadastros.enums.StatusAtendimento;

import java.util.*;

public class CadastroPaciente {
    public static void cadastrarPaciente(){
        System.out.println("-------------------------------------------------");
        System.out.println("Cadastro de Paciente");
        System.out.println();
        try {
            List<String> infos = obterInformacoes();

            new Paciente(
                    infos.get(0),
                    infos.get(1),
                    CadastroHelpers.transformaStringEmData(infos.get(2)),
                    infos.get(3),
                    infos.get(4),
                    infos.get(5),
                    obterAlergias(),
                    obterCuidadosEspeciais(),
                    infos.get(6),
                    infos.get(7),
                    CadastroHelpers.transformaStringEmData(infos.get(8)),
                    obterStatusDeAtendimento());

        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private static List<String> obterInformacoes() {
        List<String> infos = new ArrayList<>(CadastroHelpers.obterInfosDePessoa());

        infos.add(obterContatoDeEmergencia());
        if (possuiConvenio()) {
            infos.addAll(obterInfosDeConvenio());
        } else {
            infos.add("Sem convênio");
            infos.add("0");
            infos.add("01/01/1000");
        }

        return infos;
    }

    private static String obterContatoDeEmergencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Contato de emergência: ");
        return scanner.nextLine();
    }

    private static boolean possuiConvenio() {
        boolean respostaValida = false;
        boolean possuiConvenio = false;

        while(!respostaValida) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Paciente possui convênio?");
            System.out.println("1. Sim");
            System.out.println("2. Não");
            String resposta = scanner.nextLine();

            if (Objects.equals(resposta, "1") || Objects.equals(resposta, "2")) {
                possuiConvenio = Objects.equals(resposta, "1");
                respostaValida = true;
            } else {
                CadastroHelpers.printError("Digite '1' para 'sim' e '2' para 'não'.");
            }
        }
        
        return possuiConvenio;
    }

    private static List<String> obterInfosDeConvenio(){
        List<String> infos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome do convênio:");
        infos.add(scanner.nextLine());

        System.out.println("Número/código do convênio:");
        infos.add(scanner.nextLine());

        boolean dataValida = false;
        while(!dataValida) {
            System.out.println("Validade do Convênio: ");
            String validade = scanner.nextLine();
            if(CadastroHelpers.validaData(validade)){
                dataValida = true;
                infos.add(validade);
            } else {
                CadastroHelpers.printError("Data deve estar no formato dd/mm/aaaa");
            }
        }

        return infos;
    }


    private static List<String> obterAlergias() {
        List<String> alergias = new ArrayList<>();
        String possuiAlergia = "";

        boolean respostaValida = false;
        while(!respostaValida) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Paciente possui alergias?");
            System.out.println("1. Sim");
            System.out.println("2. Não");
            possuiAlergia = scanner.nextLine();
            if (Objects.equals(possuiAlergia, "1") || Objects.equals(possuiAlergia, "2")) {
                respostaValida = true;
            } else {
                CadastroHelpers.printError("Digite '1' para 'sim' e '2' para 'não'.");
            }
        }

        if (Objects.equals(possuiAlergia, "1")) {
            boolean stop = false;

            while (!stop) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite uma alergia e pressione enter para adicioná-la a lista de alergias");
                System.out.println("Para finalizar pressione 0");
                String alergia = scanner.nextLine();

                if (Objects.equals(alergia, "0")) {
                    stop = true;
                    System.out.println("----------------------");
                    System.out.println("Alergias adicionadas: ");
                    for (String item : alergias) {
                        System.out.println(item);
                    }
                    System.out.println("----------------------");
                } else {
                    alergias.add(alergia);
                    System.out.println("----------------------");
                    System.out.println("Alergia cadastradas");
                    System.out.println("----------------------");
                }
            }
        } else {
            alergias.add("Sem alergias");
        }
        return alergias;
    }

    private static List<String> obterCuidadosEspeciais() {
        List<String> cuidados = new ArrayList<>();
        String necessitaCuidados = "";

        boolean respostaValida = false;
        while(!respostaValida) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Paciente necessita cuidados especiais?");
            System.out.println("1. Sim");
            System.out.println("2. Não");
            necessitaCuidados = scanner.nextLine();
            if (Objects.equals(necessitaCuidados, "1") || Objects.equals(necessitaCuidados, "2")) {
                respostaValida = true;
            } else {
                CadastroHelpers.printError("Digite '1' para 'sim' e '2' para 'não'.");
            }
        }

        if (Objects.equals(necessitaCuidados, "1")) {
            boolean stop = false;

            while (!stop) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite uma necessidade especial e pressione enter para adicioná-la a lista de cuidados");
                System.out.println("Para finalizar pressione 0");
                String cuidado = scanner.nextLine();

                if (Objects.equals(cuidado, "0")) {
                    stop = true;
                    System.out.println("----------------------");
                    System.out.println("Necessidade especiais adicionadas: ");
                    for (String item : cuidados) {
                        System.out.println(item);
                    }
                    System.out.println("----------------------");
                } else {
                    cuidados.add(cuidado);
                    System.out.println("----------------------");
                    System.out.println("Necessidade especial cadastrada");
                    System.out.println("----------------------");
                }
            }
        } else {
            cuidados.add("Não necessita cuidados especiais");
        }
        return cuidados;
    }

    private static StatusAtendimento obterStatusDeAtendimento() {
        System.out.println("Qual o status de atendimento do paciente?");
        System.out.println("1. Aguardando atendimento");
        System.out.println("2. Em atendimento");
        System.out.println("3. Atendindo");
        System.out.println("4. Não atendido");
        
        StatusAtendimento statusDoPaciente = null;

        try {
            Scanner scanner = new Scanner(System.in);
            int status = scanner.nextInt();
            if (status > 0 && status < 5) {
                switch (status) {
                    case 1 -> {
                        statusDoPaciente = StatusAtendimento.AGUARDANDO_ATENDIMENTO;
                    }
                    case 2 -> {
                        statusDoPaciente = StatusAtendimento.EM_ATENDIMENTO;
                    }
                    case 3 -> {
                        statusDoPaciente = StatusAtendimento.ATENDIDO;
                    }
                    case 4 -> {
                        statusDoPaciente = StatusAtendimento.NAO_ATENDIDO;
                    }
                }
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            CadastroHelpers.printError("Digite um número entre 1 e 4.");
            obterStatusDeAtendimento();
        }

        return statusDoPaciente;
    }
}
