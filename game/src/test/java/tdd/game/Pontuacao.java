package tdd.game;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pontuacao {
	private Map<String, Integer> ponto = new LinkedHashMap<>();
	
	public Integer getPontos(String tipoPonto) {
		return ponto.getOrDefault(tipoPonto, 0);
	}
	public void adicionarPontos(String tipoPontuacao, int quantidadePontuacao) {
		Integer pontuacaoAtual = this.getPontos(tipoPontuacao);
		ponto.put(tipoPontuacao, pontuacaoAtual + quantidadePontuacao);	
		
	}
}
