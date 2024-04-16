package org.serratec.poo.academia;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.serratec.poo.academia.Pessoa.getListaAgendamento;
import static org.serratec.poo.principal.Programa.sc;

public class AgendamentoMetodos{
    static List<Agendamento> agendamentos = new ArrayList<>();
    static String diretorio = getListaAgendamento();
    public static List<Agendamento> listaAgendamento() {

        try {
            BufferedReader txt = new BufferedReader(new FileReader(diretorio));

            String linha;
            while ((linha = txt.readLine()) != null) {
                // Processar cada linha
                String[] dados = linha.split(";");
                LocalDate dataAgendamento = LocalDate.parse(dados[2]);
                LocalTime horaAgendamento = LocalTime.parse(dados[3]);
                Status status = Status.valueOf(dados[4].toUpperCase());

                Agendamento agendamento = new Agendamento(new Horario(dataAgendamento, horaAgendamento), // data e hora
                        // agendamento
                        dados[0], // Nome aluno
                        dados[1], // Nome personal
                        status);// Status
                agendamentos.add(agendamento);
            }
            txt.close();
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao encontrar arquivo: " + e.getMessage());

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + e.getMessage());
        }
        return agendamentos;
    }
    public static void novoAgendamento() {
        System.out.print("Data Agendamento: ");
        LocalDate dataAgendamento = LocalDate.parse(sc.nextLine());
        System.out.print("Hora Agendamento: ");
        LocalTime horaAgendamento = LocalTime.parse(sc.nextLine());
        System.out.print("CPF Aluno Agendado: ");
        String nomeAluno = sc.nextLine();
        System.out.print("Personal Trainer: ");
        String nomePersonal = sc.nextLine();
        System.out.print("Status Agendamento: ");
        Status status = leStatus();
        Agendamento novoAgendamento = new Agendamento(new Horario(dataAgendamento, horaAgendamento), nomeAluno,
                nomePersonal, status);
        agendamentos.add(novoAgendamento);
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(getListaAgendamento()))) {
            for (Agendamento agendamento : agendamentos) {
                escritor.write(agendamento.toString2());
                escritor.newLine();
            }
            System.out.println("Agendamento realizado com sucesso.");
        } catch (IOException e) {
            System.err.println("\nErro ao agendar atendimento!");
        }
    }
    public static Status leStatus() {
        int opcao = -1;
        Status status = null;

        boolean statusOK = false;
        while (!statusOK) {
            System.out.printf("""
					1- Pendente
					2- Concluído
					3- Desmarcado

					""");

            opcao = sc.nextInt();

            if (opcao == 1) {
                status = Status.PENDENTE;
                break;
            } else if (opcao == 2) {
                status = Status.CONCLUIDO;
                break;
            } else if (opcao == 3) {
                status = Status.DESMARCADO;
                break;
            }
        }
        return status;
    }
}