package org.serratec.poo.academia;

import org.serratec.poo.alunos.Aluno;
import org.serratec.poo.funcionarios.Funcionario;
import org.serratec.poo.personaltrainers.PersonalTrainer;

import java.io.IOException;
import java.util.List;

import static org.serratec.poo.academia.Login.chamaLogin;
import static org.serratec.poo.principal.Programa.sc;

public class LoginMetodos {
	public static Object validaLogin(String cpf, String senha, List<Aluno> alunos, List<PersonalTrainer> personais,
			List<Funcionario> funcionarios) throws IOException {

		Object pessoa = null;
		boolean encontrado = false;

		for (Aluno aluno : alunos) {
			if (aluno.getCpf().equals(cpf) && aluno.getSenha().equals(senha)) {
				encontrado = true;
				pessoa = aluno;
				System.out.printf("\t\t======== BEM VINDO %s ==========\n\n", aluno.getNome());
				break;
			}
		}
		if (!encontrado) {
			for (PersonalTrainer personalTrainer : personais) {
				if (personalTrainer.getCpf().equals(cpf) && personalTrainer.getSenha().equals(senha)) {
					encontrado = true;
					pessoa = personalTrainer;
					System.out.printf("\t\t======== BEM VINDO %s ==========\n\n", personalTrainer.getNome());
					break;
				}
			}
		}
		if (!encontrado) {
			for (Funcionario funcionario : funcionarios) {
				if (funcionario.getCpf().equals(cpf) && funcionario.getSenha().equals(senha)) {
					encontrado = true;
					pessoa = funcionario;
					System.out.printf("\t\t======== BEM VINDO %s ==========\n\n", funcionario.getNome());
					break;
				}
			}
		}

		if (!encontrado) {
			System.out.println(String.format("""
					USUARIO OU SENHA ERRADOS...
					DESEJA BUSCAR UM NOVO CPF? (S/N)
					"""));
			String aux = sc.nextLine();
			if (aux.equalsIgnoreCase("s")) {
				chamaLogin();
			} else {
				System.out.println(String.format("""
						OBRIGADO POR UTILIZAR NOSSO SISTEMA...
						"""));
			}
		}
		return pessoa;
	}

}
