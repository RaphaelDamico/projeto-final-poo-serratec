package org.serratec.poo.academia;

import org.serratec.poo.alunos.Aluno;
import org.serratec.poo.alunos.MenuAluno;
import org.serratec.poo.funcionarios.Funcionario;
import org.serratec.poo.funcionarios.MenuFuncionario;
import org.serratec.poo.personaltrainers.MenuPersonal;
import org.serratec.poo.personaltrainers.PersonalTrainer;

import java.io.IOException;
import java.util.List;

import static org.serratec.poo.academia.Utils.limpaTela;
import static org.serratec.poo.alunos.MetodosAluno.listaAluno;
import static org.serratec.poo.funcionarios.MetodosFuncionario.listaFuncionario;
import static org.serratec.poo.personaltrainers.MetodosPersonal.listaPersonal;
import static org.serratec.poo.principal.Programa.sc;
import static org.serratec.poo.academia.LoginMetodos.validaLogin;

public class Login {
	public static void chamaLogin() throws IOException {

		List<Aluno> alunos = listaAluno();
		List<PersonalTrainer> personais = listaPersonal();
		List<Funcionario> funcionarios = listaFuncionario();

		String cpf;
		String senha;

		do {
			System.out.print("Insira seu CPF:");
			cpf = sc.nextLine();
			System.out.print("Senha: ");
			senha = sc.nextLine();
			limpaTela();
		} while (cpf == "" || senha == "");

		Pessoa pessoa = (Pessoa) validaLogin(cpf, senha, alunos, personais, funcionarios);

		Menu menu;
		int opcao = 0;
		if (pessoa instanceof Aluno) {
			menu = new MenuAluno((Aluno) pessoa);
			while (opcao != 6) {
				menu.exibeMenu();
				opcao = sc.nextInt();
				menu.escolhaMenu(opcao);
			}
		}
		if (pessoa instanceof PersonalTrainer) {
			while (opcao != 4) {
				menu = new MenuPersonal((PersonalTrainer) pessoa);
				menu.exibeMenu();
				opcao = sc.nextInt();
				menu.escolhaMenu(opcao);
			}
		}
		if (pessoa instanceof Funcionario) {
			while (opcao != 7) {
				menu = new MenuFuncionario((Funcionario) pessoa);
				menu.exibeMenu();
				opcao = sc.nextInt();
				menu.escolhaMenu(opcao);
			}
		} else {
			System.out.println("OBRIGADO POR USAR NOSSO SISTEMA");
			return;
		}
		//sc.close();
	}
}