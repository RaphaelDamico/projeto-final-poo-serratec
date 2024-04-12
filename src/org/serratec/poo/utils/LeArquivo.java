package org.serratec.poo.utils;

import org.serratec.poo.classes.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.serratec.poo.classes.Pessoa.getListaAlunos;

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
                    new Plano(dados[6], dados[7], Double.parseDouble(dados[8]), dados[9]),//plano
                    dados[10]);
            alunos.add(aluno);
        }

        return alunos;
    }

    public static void main(String[] args) throws IOException {
        List<Aluno> alunos = listaAluno();
        System.out.println(alunos);
    }
}
