package org.serratec.poo.classes;

import java.util.Scanner;
import static org.serratec.poo.utils.UtilsMenu.*;
import static org.serratec.poo.utils.Utils.*;

public class Menu {

	public static void menuAluno(Object pessoa) {
		Aluno aluno = (Aluno) pessoa;
		Scanner sc = new Scanner(System.in);
		int op = 0;
		while (op != 6) {
			exibeMenuAluno();
			op = sc.nextInt();
			switch (op) {
			case 1:
				System.out.println(pessoa);
				break;
			case 2:
				break;
			case 3:
				System.out.println("VAMO PORRAAAAAAA");
				break;
			case 4:
				break;
			case 5:
				visualizarAvaliacoesAluno(aluno.getCpf());
				break;
			case 6:
				break;
			}
		}
		sc.close();
	}

	public static void menuPersonal(Object pessoa) {
		PersonalTrainer personalTrainer = (PersonalTrainer) pessoa;
		Scanner sc = new Scanner(System.in);
		int op = 0;
		while (op !=4){
			exibeMenuPersonal();
			op = sc.nextInt();
			switch (op){
				case 1:

				break;
			case 2:
				break;
			case 3:
				visualizarAvaliacoesPersonal(personalTrainer.getNome());
				break;
			case 4:
				break;
			}
		}
		sc.close();
	}

	public static void menuFuncionario(Object pessoa) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		while (op != 7) {
			exibeMenuFuncionario();
			op = sc.nextInt();
			switch (op) {
			case 1:
				novoPlano();
				break;
			case 2:
				novoAluno();
				break;
			case 3:
				novoPersonal();
				break;
			case 4:
				mostraPlanos();
				break;
			case 5:
				mostraPersonal();
				break;
			case 6:
				break;
			case 7:
				break;
			}
		}
		sc.close();
	}
}
