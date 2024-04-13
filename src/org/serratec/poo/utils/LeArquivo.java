package org.serratec.poo.utils;

import org.serratec.poo.classes.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.serratec.poo.classes.Pessoa.*;

public class LeArquivo {
    public static List<Aluno> listaAluno() {
    	List<Aluno> alunos = new ArrayList<>();
    	try {
	        String diretorio = getListaAlunos();
	        BufferedReader txt = new BufferedReader(new FileReader(diretorio));
	
	        String linha;
	        while ((linha = txt.readLine()) != null) {
	            // Processar cada linha
	            String[] dados = linha.split("-");
	
	            Aluno aluno = new Aluno(dados[0], //Nome
	                    dados[1], //Data nascimento
	                    dados[2], //cpf
	                    new Contato(dados[3], dados[4]), //contato
	                    dados[5], //senha
	                    dados[6],//plano
	                    dados[10],// Data matricula
	                    dados[11]);//Avaliacao 
	            alunos.add(aluno);
	        }
	        txt.close();
    	}
    	catch (FileNotFoundException e) {
			System.err.println("Erro ao encontrar arquivo: " + e.getMessage());

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo " + e.getMessage());
		}
    	Collections.sort(alunos);
        return alunos;
    }
    public static List<PersonalTrainer> listaPersonal() {
    	List<PersonalTrainer> personalTrainers = new ArrayList<>();
    	try {
	        String diretorio = getListaPersonal();
	        BufferedReader txt = new BufferedReader(new FileReader(diretorio));
	
	        String linha;
	        while ((linha = txt.readLine()) != null) {
	            // Processar cada linha
	            String[] dados = linha.split("-");
	
	            PersonalTrainer personal = new PersonalTrainer(dados[0], //Nome
	                    dados[1], //Data nascimento
	                    dados[2], //cpf
	                    new Contato(dados[3], dados[4]), //contato
	                    dados[5], //senha
	                    dados[6],//especialidade
	                    dados[7]);//cref
	            personalTrainers.add(personal);
	        }
	        txt.close();
    	}
    	catch (FileNotFoundException e) {
			System.err.println("Erro ao encontrar arquivo: " + e.getMessage());

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo " + e.getMessage());
		}
    	Collections.sort(personalTrainers);
        return personalTrainers;
    }
    public static List<Funcionario> listaFuncionario() {
    	List<Funcionario> funcionarios = new ArrayList<>();
    	try {
	        String diretorio = getListaFuncionarios();
	        BufferedReader txt = new BufferedReader(new FileReader(diretorio));
	
	        String linha;
	        while ((linha = txt.readLine()) != null) {
	            // Processar cada linha
	            String[] dados = linha.split("-");
	            Cargo cargo = Cargo.valueOf(dados[6].toUpperCase());
	            Funcionario funcionario = new Funcionario(dados[0], //Nome
	                    dados[1], //Data nascimento
	                    dados[2], //cpf
	                    new Contato(dados[3], dados[4]), //contato
	                    dados[5], //senha
	                    cargo);//cargo
	            funcionarios.add(funcionario);
	        }
	        txt.close();
    	}
    	catch (FileNotFoundException e) {
			System.err.println("Erro ao encontrar arquivo: " + e.getMessage());

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo " + e.getMessage());
		}
    	Collections.sort(funcionarios);
        return funcionarios;
    }
    public static List<Plano> listaPlanos(){
        String diretorio = getListaPlanos();
        List<Plano> planos = new ArrayList();
        try (BufferedReader txt = new BufferedReader(new FileReader(diretorio))) {
            String linha;
            while((linha = txt.readLine()) != null) {
                String[] dados = linha.split("-");
                int duracao = Integer.parseInt(dados[1]);
                Double valor = Double.parseDouble(dados[2]);
                Plano plano = new Plano(dados[0], duracao, valor, dados[4]);
                planos.add(plano);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return planos;
    }
}
