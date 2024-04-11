package org.serratec.poo.classes;

public class Plano {
	private String nomeDoPlano;
	private String duracao;
	private double valor;
	private String descricao;

	public Plano(String nomeDoPlano, String duracao, double valor, String descricao) {
		this.nomeDoPlano = nomeDoPlano;
		this.duracao = duracao;
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getNomeDoPlano() {
		return nomeDoPlano;
	}

	public String getDuracao() {
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
				Duração: %s
				Valor: R$ %.2f
				Descrição do plano: %s
				""", nomeDoPlano, duracao, valor, descricao);
	}

}
