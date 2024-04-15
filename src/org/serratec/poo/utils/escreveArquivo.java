package org.serratec.poo.utils;

import static org.serratec.poo.classes.Pessoa.*;
import static org.serratec.poo.utils.LeArquivo.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.serratec.poo.classes.Status;
import org.serratec.poo.classes.Horario;
import org.serratec.poo.classes.Agendamento;

public class escreveArquivo {
	public static void novoAgendamento() {
		Scanner sc = new Scanner(System.in);
		List<Agendamento> agendamentos = (listaAgendamento());
		System.out.print("Data Agendamento: ");
		LocalDate dataAgendamento = LocalDate.parse(sc.nextLine());
		System.out.print("Hora Agendamento: ");
		String horaAgendamento = sc.nextLine();
		System.out.print("Aluno: ");
		String nomeAluno = sc.nextLine();
		System.out.print("Personal Trainer: ");
		String nomePersonal = sc.nextLine();
		System.out.print("Status Agendamento: ");
		Status status = Status.valueOf(sc.nextLine());
		System.out.println("Especialidade: ");
		Agendamento novoAgendamento = new Agendamento(new Horario(dataAgendamento, horaAgendamento), nomeAluno,
				nomePersonal, status);
		agendamentos.add(novoAgendamento);
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(getListaAgendamento()))) {
			for (Agendamento agendamento : agendamentos) {
				escritor.write(agendamento.toString2());
				escritor.newLine();
			}
			System.err.println("Agendamento realizado com sucesso.");
		} catch (IOException e) {
			System.err.println("\nErro ao agendar atendimento!");
		}
		sc.close();
	}
}
