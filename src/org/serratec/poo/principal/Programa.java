package org.serratec.poo.principal;

import java.io.IOException;
import java.util.Scanner;

import static org.serratec.poo.academia.Login.chamaLogin;

public class Programa {
	public final static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		chamaLogin();
		sc.close();
	}
}
