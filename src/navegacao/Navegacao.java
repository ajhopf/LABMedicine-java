package navegacao;

import service.CadastroHelpers;

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

            switch (opcaoSelecionada) {
                case 2:
                    CadastroEnfermeiro.cadastrarEnfermeiro();
                    break;
                default: System.out.println("Você escolheu a opção " + opcaoSelecionada);
            }

            iniciar();
        } catch (IllegalArgumentException e) {
            CadastroHelpers.printError("Você deve selecionar um número entre 1 e 6.");
            iniciar();
        } catch (InputMismatchException e){
            CadastroHelpers.printError("A opção deve ser selecionada através de um número.");
            iniciar();
        }
        catch (Exception e) {
            CadastroHelpers.printError(e.toString());
            iniciar();
        }
    }

    private static int capturarInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
