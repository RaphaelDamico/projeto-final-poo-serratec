package org.serratec.poo.classes;

import java.time.LocalDate;

public class Horario {
	private LocalDate data;
	private String hora;

	public Horario(LocalDate data, String hora) {
		this.data = data;
		this.hora = hora;
	}

	public LocalDate getData() {
		return data;
	}

	public String getHora() {
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
