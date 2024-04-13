package org.serratec.poo.classes;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.serratec.poo.utils.LeArquivo.*;
import static org.serratec.poo.utils.ProcuraLista.buscarCPF;

public class Login {
	public static void chamaLogin() throws IOException {
		List<Aluno> alunos = listaAluno();
		List<PersonalTrainer> personais = listaPersonal();
		List<Funcionario> funcionarios = listaFuncionario();
		Scanner sc = new Scanner(System.in);
		System.out.print("Insira seu CPF:");
		String cpf = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		System.out.println(buscarCPF(cpf, senha, alunos, personais, funcionarios));


		sc.close();
		
		
	
	}
	
	//TODO ValidaLogin()
	public static void main(String[] args) throws IOException {
		chamaLogin();
	}
}