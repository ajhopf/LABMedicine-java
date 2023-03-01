package navegacao;

import cadastros.Enfermeiro;
import service.CadastroHelpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroEnfermeiro {
    public static void cadastrarEnfermeiro(){
        System.out.println("-------------------------------------------------");
        System.out.println("Cadastro de Enfermeiro");
        System.out.println("-------------------------------------------------");
        try {
            List<String> infos = getInformacoes();

            new Enfermeiro(
                    infos.get(0),
                    infos.get(1),
                    CadastroHelpers.formataData(infos.get(2)),
                    infos.get(3),
                    infos.get(4),
                    infos.get(5),
                    infos.get(6));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private static List<String> getInformacoes() {
        List<String> infos = new ArrayList<>(CadastroHelpers.getBasicInfos());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Instituição de Ensino da Formação:");
        infos.add(scanner.nextLine());
        System.out.println("COFEN/UF");
        infos.add(scanner.nextLine());

        return infos;
    }
}
