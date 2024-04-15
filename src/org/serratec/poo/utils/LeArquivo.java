package org.serratec.poo.utils;

import org.serratec.poo.classes.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
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
	            LocalDate nascimento = LocalDate.parse(dados[1]);
	            LocalDate matricula = LocalDate.parse(dados[10]);
	
	            Aluno aluno = new Aluno(dados[0], //Nome
	                    nascimento, //Data nascimento
	                    dados[2], //cpf
	                    new Contato(dados[3], dados[4]), //contato
	                    dados[5], //senha
	                    dados[6],//plano
	                    matricula,// data matricula
	                    dados[11]);// status avaliacao
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
	            LocalDate nascimento = LocalDate.parse(dados[1]);
	
	            PersonalTrainer personal = new PersonalTrainer(
	            		dados[0], //Nome
	                    nascimento, //Data nascimento
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
	            LocalDate nascimento = LocalDate.parse(dados[1]);
	            Cargo cargo = Cargo.valueOf(dados[6].toUpperCase());
	            Funcionario funcionario = new Funcionario(
	            		dados[0], //Nome
	                    nascimento, //Data nascimento
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
        List<Plano> planos = new ArrayList<>();
        try (BufferedReader txt = new BufferedReader(new FileReader(diretorio))) {
            String linha;
            while((linha = txt.readLine()) != null) {
                String[] dados = linha.split("-");
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
    public static List<Avaliacao> listaAvaliacoes() {
    	List<Avaliacao> avaliacoes = new ArrayList<>();
    	try {
	        String diretorio = getListaAvaliacoes();
	        BufferedReader txt = new BufferedReader(new FileReader(diretorio));
	
	        String linha;
	        while ((linha = txt.readLine()) != null) {
	            // Processar cada linha
	            String[] dados = linha.split("-");
	            LocalDate dataAvaliacao = LocalDate.parse(dados[2]);
	            double altura = Double.parseDouble(dados[4]);
	            double peso = Double.parseDouble(dados[5]);
	            double taxaGordura = Double.parseDouble(dados[6]);
	
	            Avaliacao avaliacao = new Avaliacao(dados[0], //Nome aluno
	                    dados[1], //Nome personal
	                    new Horario(dataAvaliacao, dados[3]), //data e hora da avaliacao
	                    altura, //Altura
	                    peso,//Peso
	                    taxaGordura,// Taxa de gordura
	                    dados[7]);//Restrição
	            avaliacoes.add(avaliacao);
	        }
	        txt.close();
    	}
    	catch (FileNotFoundException e) {
			System.err.println("Erro ao encontrar arquivo: " + e.getMessage());

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo " + e.getMessage());
		}
        return avaliacoes;
    }
}
