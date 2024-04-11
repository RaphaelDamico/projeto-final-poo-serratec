package org.serratec.poo.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utils {
	private DateTimeFormatter fmt;
	
	public LocalDate formataDataDeNascimento(LocalDate dataDeNascimento) {
		Scanner sc = new Scanner(System.in);
		fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
		dataDeNascimento = LocalDate.parse(sc.nextLine(), fmt);
		sc.close();
		return dataDeNascimento;
	}
	
//	public LocalDate converteIdade(LocalDate dataDeNascimento) {
//		LocalDate dataAtual = LocalDate.now();
//		Period period = Period.between(dataDeNascimento, dataAtual);
//		return period.getYears();
//	}
}
