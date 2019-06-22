package tdd.game;

public class Usuario {
	private Pontuacao pontuacao;
	private String nome;	
	
	public Usuario(String nome) {
		this.nome = nome;
		this.pontuacao = new Pontuacao();
	}
	
	public Pontuacao getPontuacao() {
		return this.pontuacao;
	}
	
	public String getNome() {
		return nome;
	}
	public Integer getPontos(String tipoPonto) {
		return pontuacao.getPontos(tipoPonto);
	}

	public void adicionarPontos(String tipoPontuacao, int quantidadePontuacao) {
		if (quantidadePontuacao > 0) {
			this.pontuacao.adicionarPontos(tipoPontuacao, quantidadePontuacao);
		}
		
	}

}
