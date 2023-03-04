package repository;

import cadastros.Enfermeiro;
import cadastros.Medico;
import cadastros.Paciente;
import cadastros.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {
    static public List<Pessoa> getTodasPessoas() {
        List<Pessoa> listaAtualizada = new ArrayList<>();

        listaAtualizada.addAll(EnfermeirosRepository.getEnfermeirosCadastrados());
        listaAtualizada.addAll(MedicosRepository.getMedicosCadastrados());
        listaAtualizada.addAll(PacientesRepository.getPacientesCadastrados());

        return listaAtualizada;
    }

    static public void mostrarListaDePessoasFormatada() {
        System.out.println("------------------------------------");
        System.out.println("Pacientes: ");
        for (Paciente paciente : PacientesRepository.getPacientesCadastrados()) {
            System.out.println();
            System.out.println("Código: " + paciente.getId());
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("CPF: " + paciente.getCpf());
        }
        System.out.println("------------------------------------");

        System.out.println("Médicos: ");
        for (Medico medico : MedicosRepository.getMedicosCadastrados()) {
            System.out.println();
            System.out.println("Código: " + medico.getId());
            System.out.println("Nome: " + medico.getNome());
            System.out.println("CPF: " + medico.getCpf());
        }
        System.out.println("------------------------------------");

        System.out.println("Enfermeiros: ");
        for (Enfermeiro enfermeiro : EnfermeirosRepository.getEnfermeirosCadastrados()) {
            System.out.println();
            System.out.println("Código: " + enfermeiro.getId());
            System.out.println("Nome: " + enfermeiro.getNome());
            System.out.println("CPF: " + enfermeiro.getCpf());
        }
        System.out.println("------------------------------------");
    }
}
