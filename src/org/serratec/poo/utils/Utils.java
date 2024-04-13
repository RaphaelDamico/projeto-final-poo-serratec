package org.serratec.poo.utils;

import org.serratec.poo.classes.Plano;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static org.serratec.poo.classes.Pessoa.getListaPlanos;
import static org.serratec.poo.utils.LeArquivo.listaPlanos;

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

	public static String cadastra(){
		Scanner np = new Scanner (System.in);
		String nova = np.nextLine();
		np.close();
		return nova;
	}

	public static void novoPlano(){
		List<Plano> planos = (listaPlanos());
		System.out.println("Qual o nome do novo Plano?");
		String nomePlano = cadastra();
		System.out.println("Qual a duração do novo Plano?");
		int duracao = Integer.parseInt(cadastra());
		System.out.println("Qual o valor do novo Plano?");
		double valor = Double.parseDouble(cadastra());
		System.out.println("Qual a descrição do novo Plano?");
		String descricao = cadastra();
		Plano novoPlano =  new Plano(nomePlano, duracao, valor, descricao);
		planos.add(novoPlano);
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(getListaPlanos()))) {
			for (Plano plano : planos) {
				escritor.write(plano.toString2());
				escritor.newLine();
			}
			System.out.println("Plano cadastrado com sucesso.");
		}
		catch (IOException e) {
			System.out.println("\nErro cadastrar novo plano.");
		}
	}

//	public LocalDate converteIdade(LocalDate dataDeNascimento) {
//		LocalDate dataAtual = LocalDate.now();
//		Period period = Period.between(dataDeNascimento, dataAtual);
//		return period.getYears();
//	}
}
