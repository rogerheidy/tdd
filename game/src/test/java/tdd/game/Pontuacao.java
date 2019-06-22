package tdd.game;

public class Pontuacao {
	Ponto ponto;
	public Integer getPontos(String tipoPonto) {
		return ponto.getQuantidade();
	}
	public void adicionarPontos(String tipoPontuacao, int quantidadePontuacao) {
		Integer pontuacaoAtual = this.getPontos(tipoPontuacao);
		ponto.put(tipoPontuacao, pontuacaoAtual + quantidadePontuacao);	
		
	}
}
