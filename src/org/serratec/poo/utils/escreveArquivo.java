package org.serratec.poo.utils;

import static org.serratec.poo.classes.Pessoa.getListaAgendamento;
import static org.serratec.poo.utils.LeArquivo.listaAgendamento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import org.serratec.poo.classes.Agendamento;
import org.serratec.poo.classes.Horario;
import org.serratec.poo.classes.Status;

public class escreveArquivo {
	public static void novoAgendamento() {
		Scanner sc = new Scanner(System.in);
		List<Agendamento> agendamentos = listaAgendamento();
		System.out.print("Data Agendamento: ");
		LocalDate dataAgendamento = LocalDate.parse(sc.nextLine());
		System.out.print("Hora Agendamento: ");
		LocalTime horaAgendamento = LocalTime.parse(sc.nextLine());
		System.out.print("Aluno: ");
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
		sc.close();
	}

	public static Status leStatus() {
		Scanner s = new Scanner(System.in);
		int opcao = -1;
		Status status = null;

		boolean statusOK = false;
		while (!statusOK) {
			System.out.printf("""
					1- Pendente
					2- Concluído
					3- Desmarcado

					""");

			opcao = s.nextInt();

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
