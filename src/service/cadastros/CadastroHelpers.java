package service.cadastros;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CadastroHelpers {
    public static void printError(String message) {
        System.out.println("-------------------------------------------------");
        System.out.println("Opção inválida, tente novamente.");
        System.out.println("Erro:");
        System.out.println(message);
        System.out.println("-------------------------------------------------");
    }

    public static List<String> obterInfosDePessoa() {
        List<String> infos = new ArrayList<>();

        infos.add(obterNome());
        infos.add(obterGenero());
        infos.add(obterDob());
        infos.add(obterCpf());
        infos.add(obterTelefone());

        return infos;
    }

    private static String obterNome() {
        String nome;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nome completo:");
            nome = scanner.nextLine();
            if (nome.length() == 0) {
                CadastroHelpers.printError("Digite o nome completo.");
            }
        } while (nome.length() == 0);

        return nome;
    }

    private static String obterGenero() {
        Scanner scanner = new Scanner(System.in);
        String genero = null;
        boolean generoValido = false;

        while(!generoValido) {
            System.out.println("Gênero: ");
            genero = scanner.nextLine();
            if (!validaGenero(genero)) {
                printError("O gênero deve ser 'masculino', 'feminino' ou 'outro'.");
            } else {
                generoValido = true;
            }
        }

        return genero;
    }

    private static String obterDob() {
        Scanner scanner = new Scanner(System.in);
        String dob = null;

        boolean dobValida = false;

        while(!dobValida) {
            System.out.println("Data de Nascimento: ");
            dob = scanner.nextLine();
            if(validaData(dob)){
                dobValida = true;
            } else {
                printError("Data deve estar no formato dd/mm/aaaa");
            }
        }

        return dob;
    }

    private static String obterCpf() {
        Scanner scanner = new Scanner(System.in);
        String cpf = null;

        boolean cpfValido = false;

        while (!cpfValido) {
            System.out.println("CPF: ");
            cpf = scanner.nextLine();
            if (validaCPF(cpf)) {
                cpfValido = true;
            } else {
                printError("CPF deve conter 11 dígitos e estar no formato '111.222.333-44' ou '11122233344'.");
            }
        }

        cpf = formataCPF(cpf);

        return cpf;
    }

    private static String obterTelefone() {
        Scanner scanner = new Scanner(System.in);
        String telefone = null;

        boolean telefoneValido = false;

        while(!telefoneValido) {
            System.out.println("Telefone: ");
            telefone = scanner.nextLine();
            if (validaTelefone(telefone)) {
                telefoneValido = true;
            } else {
                printError("Telefone deve conter entre 8 e 9 dígitos. O DDD é opcional e deve estar entre parênteses.");
            }
        }

        return telefone;
    }

    private static boolean validaTelefone(String telefone) {
        return telefone.matches("^(\\(\\d{2}\\)\\s?)?(\\d{4,5}\\-?\\d{4})$");
    }


    public static Date transformaStringEmData(String data) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return formatter.parse(data);
    }



    private static boolean validaGenero(String genero) {
        return (Objects.equals(genero.toLowerCase(), "masculino") || Objects.equals(genero.toLowerCase(), "feminino") || Objects.equals(genero.toLowerCase(), "outro"));
    }

    private static boolean validaCPF(String cpf) {
        return cpf.matches("^(([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})|([0-9]{11}))$");
    }

    private static String formataCPF(String cpf) {
        if (cpf.matches("^[0-9]{11}$")) {
            String first = cpf.substring(0, 3);
            String second = cpf.substring(3, 6);
            String third = cpf.substring(6, 9);
            String last = cpf.substring(9);
            cpf = first + "." + second + "." + third + "-" + last;
        }
        return cpf;
    }


    public static boolean validaData(String dob) {
        return dob.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$");
    }
}
