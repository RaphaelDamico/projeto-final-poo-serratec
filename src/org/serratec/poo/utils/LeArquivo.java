package org.serratec.poo.utils;

import org.serratec.poo.classes.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.serratec.poo.classes.Pessoa.*;

public class LeArquivo {
    public static List<Aluno> listaAluno() throws IOException {
        String diretorio = getListaAlunos();
        BufferedReader txt = new BufferedReader(new FileReader(diretorio));
        List<Aluno> alunos = new ArrayList();

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
                    dados[7]);
            alunos.add(aluno);
        }
        return alunos;
    }
    public static List<PersonalTrainer> listaPersonal() throws IOException {
        String diretorio = getListaPersonal();
        BufferedReader txt = new BufferedReader(new FileReader(diretorio));
        List<PersonalTrainer> personalTrainers = new ArrayList();

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
        return personalTrainers;
    }
    public static List<Funcionario> listaFuncionario() throws IOException {
        String diretorio = getListaFuncionarios();
        BufferedReader txt = new BufferedReader(new FileReader(diretorio));
        List<Funcionario> funcionarios = new ArrayList();

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
        return funcionarios;
    }
}
