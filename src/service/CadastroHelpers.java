package service;

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

    public static List<String> getBasicInfos() {
        List<String> infos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome Completo: ");
        infos.add(scanner.nextLine());

        boolean generoValido = false;
        while(!generoValido) {
            System.out.println("Gênero: ");
            String genero = scanner.nextLine();
            if (!validaGenero(genero)) {
                printError("O gênero deve ser 'masculino', 'feminino' ou 'outro'.");
            } else {
                infos.add(genero);
                generoValido = true;
            }
        }

        boolean dobValida = false;
        while(!dobValida) {
            System.out.println("Data de Nascimento: ");
            String dob = scanner.nextLine();
            if(validaDob(dob)){
                dobValida = true;
                infos.add(dob);
            } else {
                printError("Data deve estar no formato dd/mm/aaaa");
            }
        }

        System.out.println("CPF: ");
        infos.add(scanner.nextLine());

        System.out.println("Telefone: ");
        infos.add(scanner.nextLine());

        return infos;
    }

    public static Date formataData(String data) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(data);

        return date;
    }

    private static boolean validaGenero(String genero) {
        return (Objects.equals(genero.toLowerCase(), "masculino") || Objects.equals(genero.toLowerCase(), "feminino") || Objects.equals(genero.toLowerCase(), "outro"));
    }

    private static boolean validaDob(String dob) {
        return dob.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$");
    }
}
