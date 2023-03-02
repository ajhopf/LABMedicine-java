package navegacao;

import cadastros.Enfermeiro;
import cadastros.Medico;
import cadastros.Paciente;
import cadastros.Pessoa;
import repository.EnfermeirosRepository;
import repository.MedicosRepository;
import repository.PacientesRepository;
import repository.PessoaRepository;
import service.CadastroHelpers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ListagemPessoas {
    public static void gerarMenuDePessoas() {
        System.out.println("--------------------------------------");
        System.out.println("Qual categoria de pessoas você deseja visualizar?");
        System.out.println("1. Pacientes");
        System.out.println("2. Enfermeiros");
        System.out.println("3. Medicos");
        System.out.println("4. Todos");
        System.out.println("Selecione o número da opção desejada: ");

        try {
            Scanner scanner = new Scanner(System.in);

            int opcao = scanner.nextInt();

            if (opcao < 0 || opcao > 4) {
                throw new IllegalArgumentException();
            }

            gerarRelatorioDePessoas(opcao);
        } catch (IllegalArgumentException | InputMismatchException e) {
            CadastroHelpers.printError("Selecione a opção através de um número entre '1' e '4'.");
            gerarMenuDePessoas();
        }
    }

    private static void gerarRelatorioDePessoas(int opcao){
        switch (opcao) {
            case 1:
                List<Paciente> listaPacientes = PacientesRepository.getPacientesCadastrados();

                for (Paciente paciente : listaPacientes) {
                    System.out.println("-------------------");
                    System.out.println("Código: " + paciente.getId());
                    System.out.println("Nome: " + paciente.getNome());
                    System.out.println("CPF: " + paciente.getCpf());
                }
                System.out.println("-------------------");
                break;
            case 2:
                List<Enfermeiro> listaEnfermeiros = EnfermeirosRepository.getEnfermeirosCadastrados();
                for (Enfermeiro enfermeiro : listaEnfermeiros) {
                    System.out.println("-------------------");
                    System.out.println("Código: " + enfermeiro.getId());
                    System.out.println("Nome: " + enfermeiro.getNome());
                    System.out.println("CPF: " + enfermeiro.getCpf());
                }
                System.out.println("-------------------");
                break;
            case 3:
                List<Medico> listaMedicos = MedicosRepository.getMedicosCadastrados();
                for (Medico medico : listaMedicos) {
                    System.out.println("-------------------");
                    System.out.println("Código: " + medico.getId());
                    System.out.println("Nome: " + medico.getNome());
                    System.out.println("CPF: " + medico.getCpf());
                }
                System.out.println("-------------------");
                break;
            default:
                List<Pessoa> listaPessoas = PessoaRepository.getTodasPessoas();
                for (Pessoa pessoa : listaPessoas) {
                    System.out.println("-------------------");
                    System.out.println("Código: " + pessoa.getId());
                    System.out.println("Nome: " + pessoa.getNome());
                    System.out.println("CPF: " + pessoa.getCpf());
                }
                System.out.println("-------------------");
                break;
        }
    }
}
