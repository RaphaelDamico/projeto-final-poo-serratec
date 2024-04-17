package org.serratec.poo.academia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.serratec.poo.academia.Pessoa.getListaPlanos;
import static org.serratec.poo.principal.Programa.sc;

public class PlanoMetodos {
	public static List<Plano> listaPlanos() {
		String diretorio = getListaPlanos();
		List<Plano> planos = new ArrayList<>();
		try (BufferedReader txt = new BufferedReader(new FileReader(diretorio))) {
			String linha;
			while ((linha = txt.readLine()) != null) {
				String[] dados = linha.split(";");
				int duracao = Integer.parseInt(dados[1]);
				Double valor = Double.parseDouble(dados[2]);
				String descricao = dados[3];
				Plano plano = new Plano(dados[0], duracao, valor, descricao);
				planos.add(plano);
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
		return planos;
	}

	public static void novoPlano() {
		List<Plano> planos = (listaPlanos());
		System.out.println("Qual o nome do novo Plano?");
		sc.nextLine();
		String nomePlano = sc.nextLine();
		System.out.println("Qual a duração do novo Plano?");
		int duracao = sc.nextInt();
		System.out.println("Qual o valor do novo Plano?");
		double valor = sc.nextDouble();
		System.out.println("Qual a descrição do novo Plano?");
		sc.nextLine();
		String descricao = sc.nextLine();
		System.out.println("\n");
		Plano novoPlano = new Plano(nomePlano, duracao, valor, descricao);
		planos.add(novoPlano);
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(getListaPlanos()))) {
			for (Plano plano : planos) {
				escritor.write(plano.toString2());
				escritor.newLine();
			}
			System.out.println("Plano cadastrado com sucesso.");
		} catch (IOException e) {
			System.out.println("\nErro cadastrar novo plano.");
		} 
	}

	public static void mostraPlanos() {
		List<Plano> planos = (listaPlanos());
		for (Plano plano : planos) {
			System.out.println(plano);
		}
	}
}
