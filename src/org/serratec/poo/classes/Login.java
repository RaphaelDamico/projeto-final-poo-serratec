package org.serratec.poo.classes;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.serratec.poo.classes.Menu.*;
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
		int marcador = buscarCPF(cpf, senha, alunos, personais, funcionarios);
		if (marcador == 1){
			System.out.println("\n\n\t\t\t\tOVOKURINGAR");
			menuAluno();
		}
		if (marcador == 2){
			menuPersonal();
		}
		if (marcador == 3){
			menuFuncionario();
		}
		sc.close();
	}
	
	//TODO ValidaLogin()
	public static void main(String[] args) throws IOException {
		chamaLogin();
	}
}