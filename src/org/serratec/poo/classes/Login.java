package org.serratec.poo.classes;

import java.util.Scanner;

public class Login {
	public static void chamaLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Insira seu CPF:");
		String cpf = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();

		sc.close();
		
		
	
	}
	
	//TODO ValidaLogin()
	

}