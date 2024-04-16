package org.serratec.poo.funcionarios;

import org.serratec.poo.academia.Contato;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.serratec.poo.academia.Pessoa.getListaFuncionarios;

public class MetodosFuncionario {

	public static List<Funcionario> listaFuncionario() {
		List<Funcionario> funcionarios = new ArrayList<>();
		try {
			String diretorio = getListaFuncionarios();
			BufferedReader txt = new BufferedReader(new FileReader(diretorio));

			String linha;

			while ((linha = txt.readLine()) != null) {
				// Processar cada linha
				String[] dados = linha.split(";");
				LocalDate nascimento = LocalDate.parse(dados[1]);
				Cargo cargo = Cargo.valueOf(dados[6].toUpperCase());
				Funcionario funcionario = new Funcionario(dados[0], // Nome
						nascimento, // Data nascimento
						dados[2], // cpf
						new Contato(dados[3], dados[4]), // contato
						dados[5], // senha
						cargo);// cargo
				funcionarios.add(funcionario);
			}
			txt.close();
		} catch (FileNotFoundException e) {
			System.err.println("Erro ao encontrar arquivo: " + e.getMessage());

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo " + e.getMessage());
		}
		Collections.sort(funcionarios);
		return funcionarios;
	}
}
