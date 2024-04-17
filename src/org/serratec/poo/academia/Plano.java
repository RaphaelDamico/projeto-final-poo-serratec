package org.serratec.poo.academia;

public class Plano {
	private String nomeDoPlano;
	private int duracao;
	private double valor;
	private String descricao;

	public Plano(String nomeDoPlano, int duracao, double valor, String descricao) {
		this.nomeDoPlano = nomeDoPlano;
		this.duracao = duracao;
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getNomeDoPlano() {
		return nomeDoPlano;
	}

	public int getDuracao() {
		return duracao;
	}

	public double getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return String.format("""
				Plano: %s
				Duração: %s meses
				Valor: R$ %.2f
				Descrição do plano: %s
				""", nomeDoPlano, duracao, valor, descricao);
	}

	public String toString2() {
		return String.format("%s;%s;%s;%s", nomeDoPlano, duracao, valor, descricao);
	}

}
