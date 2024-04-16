package org.serratec.poo.academia;

import java.time.LocalDate;
import java.time.LocalTime;

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
		return String.format("""
				Data: %s
				Hora: %s
				""", data, hora);
	}

}
