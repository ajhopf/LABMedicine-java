package navegacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Navegacao {
    public static void iniciar() {
        try {
            TelaInicial.gerarMenuInicial();
            int opcaoSelecionada = capturarInput();

            if (opcaoSelecionada < 1 || opcaoSelecionada > 6 ) {
                throw new IllegalArgumentException("Número deve ser maior que 0!");
            }

            System.out.println("Você escolheu a opção " + opcaoSelecionada);
        } catch (IllegalArgumentException e) {
            printError("Você deve selecionar um número entre 1 e 6.");
            iniciar();
        } catch (InputMismatchException e){
            printError("A opção deve ser selecionada através de um número.");
            iniciar();
        }
        catch (Exception e) {
            printError(e.toString());
            iniciar();
        }
    }

    private static int capturarInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void printError(String message) {
        System.out.println("-------------------------------------------------");
        System.out.println("Opção inválida, tente novamente.");
        System.out.println("Erro:");
        System.out.println(message);
        System.out.println("-------------------------------------------------");
    }

}
