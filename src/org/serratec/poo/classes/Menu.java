package org.serratec.poo.classes;
import java.util.Scanner;
import static org.serratec.poo.utils.UtilsMenu.*;
import static org.serratec.poo.utils.Utils.*;

public class Menu {

	public static void menuAluno(Object pessoa){
		exibeMenuAluno();
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
		do{
			switch (op){
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
					break;
				case 6:
					break;
			}
		}while (op!=6);
		sc.close();
	}
	
	public static void menuPersonal(Object pessoa){
		exibeMenuPersonal();
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
		do{
			switch (op){
				case 1:

					break;
				case 2:
					break;
				case 3:
					System.out.println("VAMO PORRAAAAAAA");
					break;
				case 4:
					break;
			}
		}while (op!=4);
		sc.close();
	}
	public static void menuFuncionario(Object pessoa){
		exibeMenuFuncionario();
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
		do {
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
		}while (op !=7);
		sc.close();
	}
}
