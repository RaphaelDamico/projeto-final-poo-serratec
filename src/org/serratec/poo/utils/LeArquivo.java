package org.serratec.poo.utils;

import org.serratec.poo.classes.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeArquivo {
    public static List<Aluno> listaAluno() throws IOException {
        BufferedReader txt = new BufferedReader(new FileReader("C:/Users/joaop/OneDrive/Área de Trabalho/JAVA/projeto-final-poo-serratec/Lista Alunos.txt"));
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
                    dados[7],//data matricula
                    new Avaliacao(dados[8], new Horario(dados[9], dados [10]),
                            Double.parseDouble(dados[11]),Double.parseDouble(dados[ 12]), Double.parseDouble(dados[13]), dados[14]));
            alunos.add(aluno);
        }

        return alunos;
    }
}
