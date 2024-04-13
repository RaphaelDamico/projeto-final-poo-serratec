package org.serratec.poo.classes;

import java.util.Scanner;

import static org.serratec.poo.utils.UtilsMenu.*;

public class Menu {

	public static void menuAluno(){
		String s = exibeMenuAluno();
		System.out.println(s);
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
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
			case 5:
				break;
			case 6:
				break;
		}
	}
	public static void menuPersonal(){
		String s =exibeMenuPersonal();
		System.out.println(s);
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
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
	}
	public static void menuFuncionario(){
		String s = exibeMenuFuncionario();
		System.out.println(s);
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
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
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
		}
	}
}
