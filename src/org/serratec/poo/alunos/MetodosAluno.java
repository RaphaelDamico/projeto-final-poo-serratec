package org.serratec.poo.alunos;

import org.serratec.poo.academia.Agendamento;
import org.serratec.poo.academia.Avaliacao;
import org.serratec.poo.academia.Contato;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.serratec.poo.academia.AgendamentoMetodos.listaAgendamento;
import static org.serratec.poo.academia.AvaliacaoMetodos.listaAvaliacoes;
import static org.serratec.poo.academia.Pessoa.getListaAgendamento;
import static org.serratec.poo.academia.Pessoa.getListaAlunos;
import static org.serratec.poo.principal.Programa.sc;

public class MetodosAluno {
    public static List<Aluno> listaAluno() {
        List<Aluno> alunos = new ArrayList<>();
        try {
            String diretorio = getListaAlunos();
            BufferedReader txt = new BufferedReader(new FileReader(diretorio));

            String linha;
            while ((linha = txt.readLine()) != null) {
                // Processar cada linha
                String[] dados = linha.split(";");
                LocalDate nascimento = LocalDate.parse(dados[1]);
                LocalDate matricula = LocalDate.parse(dados[10]);

                Aluno aluno = new Aluno(dados[0], // Nome
                        nascimento, // Data nascimento
                        dados[2], // cpf
                        new Contato(dados[3], dados[4]), // contato
                        dados[5], // senha
                        dados[6], // plano
                        matricula, // data matricula
                        dados[11]);// status avaliacao
                alunos.add(aluno);
            }
            txt.close();
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao encontrar arquivo: " + e.getMessage());

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + e.getMessage());
        }
        Collections.sort(alunos);
        return alunos;
    }
    public static void novoAluno(){
        List<Aluno> alunos = (listaAluno());
        System.out.println("Nome: ");
        String nomeAluno = sc.nextLine();
        System.out.println("Data Nascimento: ");
        LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
        System.out.println("CPF: ");
        String cpf = sc.nextLine();
        System.out.println("E-mail: ");
        String email = sc.nextLine();
        System.out.println("Telefone: ");
        String telefone = sc.nextLine();
        System.out.println("Senha: ");
        String senha = sc.nextLine();
        System.out.println("Qual o plano desejado: ");
        String plano = sc.nextLine();
        System.out.println("Data Matricula: ");
        LocalDate matricula = LocalDate.parse(sc.nextLine());
        System.out.println("\n");
        Contato contato = new Contato(email, telefone);
        Aluno novoAluno =  new Aluno(nomeAluno, dataNascimento, cpf, contato, senha, plano, matricula);
        alunos.add(novoAluno);
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(getListaAlunos()))) {
            for (Aluno aluno : alunos) {
                escritor.write(aluno.toString2());
                escritor.newLine();
            }
            System.out.println("Aluno cadastrado com sucesso.");
        }
        catch (IOException e) {
            System.out.println("\nErro cadastrar novo aluno.");
        }
        sc.close();
    }
    public static void visualizarAvaliacoesAluno(String cpf) {
        List<Avaliacao> avaliacoes = listaAvaliacoes();
        List<Avaliacao> avaliacoesRealizadas = avaliacoes.stream()
                .filter(a -> a.getCpfAluno().equalsIgnoreCase(cpf)).toList();
        for (Avaliacao avaliacao : avaliacoesRealizadas) {
            System.out.println(avaliacao);
        }
    }
    public static void visualizarAgendamentosAluno(String cpf) {
        List<Agendamento> agendamentos = listaAgendamento();
        List<Agendamento> agendamentosFuturos = agendamentos.stream()
                .filter(a -> a.getCPFAluno().equalsIgnoreCase(cpf)).toList();
        for (Agendamento agendamento : agendamentosFuturos) {
            System.out.println(agendamento);
        }
    }
    public static String buscaAluno(String cpfAluno){
        List<Aluno> alunos = (listaAluno());
        String nomeAluno = null;
        boolean encontrado = false;
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().contains(cpfAluno)) {
                nomeAluno = aluno.getNome();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Aluno não encontrado!");
        }
        return nomeAluno;
    }
}
