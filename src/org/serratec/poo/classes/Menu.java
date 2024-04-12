package org.serratec.poo.classes;

import java.util.Scanner;

import org.serratec.poo.utils.UtilsMenu;

public class Menu {

	public static void menu(String opcaoMenu) {
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		boolean validaMenu = true;
		
		do {
			
			if(opcaoMenu.equalsIgnoreCase("aluno")) {
				System.out.println(UtilsMenu.exibeMenuAluno());
				if(sc.hasNextInt()) {
					opcao = sc.nextInt();
				} else {
					opcao = -1;
				}
				if(opcaoMenu.equalsIgnoreCase("personal")) {
					System.out.println(UtilsMenu.exibeMenuPersonal());
					if(sc.hasNextInt()) {
						opcao = sc.nextInt();
					} else {
						opcao = -1;
					}
				}
				if(opcaoMenu.equalsIgnoreCase("funcionario")){
					System.out.println(UtilsMenu.exibeMenuFuncionario());
					if(sc.hasNextInt()) {
						opcao = sc.nextInt();
					} else {
						opcao = -1;
					}
				}
			}
				sc.close();
		}while(validaMenu = false);
		
		
		
	}

}
