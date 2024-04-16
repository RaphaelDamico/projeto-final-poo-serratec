package org.serratec.poo.academia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.serratec.poo.academia.Pessoa.getListaAvaliacoes;

public class AvaliacaoMetodos {
    public static List<Avaliacao> listaAvaliacoes() {
        List<Avaliacao> avaliacoes = new ArrayList<>();
        try {
            String diretorio = getListaAvaliacoes();
            BufferedReader txt = new BufferedReader(new FileReader(diretorio));

            String linha;
            while ((linha = txt.readLine()) != null) {
                // Processar cada linha
                String[] dados = linha.split(";");
                LocalDate dataAvaliacao = LocalDate.parse(dados[2]);
                LocalTime horaAvaliacao = LocalTime.parse(dados[3]);
                double altura = Double.parseDouble(dados[4]);
                double peso = Double.parseDouble(dados[5]);
                double taxaGordura = Double.parseDouble(dados[6]);

                Avaliacao avaliacao = new Avaliacao(dados[0], // CPF aluno
                        dados[1], // Nome personal
                        new Horario(dataAvaliacao, horaAvaliacao), // data e hora da avaliacao
                        altura, // Altura
                        peso, // Peso
                        taxaGordura, // Taxa de gordura
                        dados[7]);// Restrição
                avaliacoes.add(avaliacao);
            }
            txt.close();
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao encontrar arquivo: " + e.getMessage());

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + e.getMessage());
        }
        return avaliacoes;
    }
}
