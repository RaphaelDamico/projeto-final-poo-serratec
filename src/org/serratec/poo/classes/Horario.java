package org.serratec.poo.classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Horario {
	private LocalDate data;
	private LocalTime hora;

	public Horario(LocalDate data, LocalTime hora) {
		this.data = data;
		this.hora = hora;
	}

	public LocalDate getData() {
		return data;
	}

	public LocalTime getHora() {
		return hora;
	}

	@Override
	public String toString() {
		DateTimeFormatter fmtd = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmth = DateTimeFormatter.ofPattern("HH:mm");
		return String.format("""
				Data: %s -- %sh
				""", data.format(fmtd), hora.format(fmth));
	}

}
