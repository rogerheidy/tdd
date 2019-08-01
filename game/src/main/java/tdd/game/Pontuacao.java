package tdd.game;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Pontuacao {
	private Map<String, Integer> ponto = new LinkedHashMap<>();
	
	public Integer getPontos(String tipoPonto) {
		return ponto.getOrDefault(tipoPonto, 0);
	}
	public void adicionarPontos(String tipoPontuacao, int quantidadePontuacao) {
		Integer pontuacaoAtual = this.getPontos(tipoPontuacao);
		ponto.put(tipoPontuacao, pontuacaoAtual + quantidadePontuacao);	
		ordenarPontosPorNome();
	}
	

	private void ordenarPontosPorNome() {
		ponto = ponto.entrySet()
			.stream()
			.sorted(Map.Entry.<String, Integer>comparingByKey())
			.collect(
				Collectors.toMap(
					Map.Entry::getKey, Map.Entry::getValue, 
					(tipoPonto, quantidade) ->
						tipoPonto, LinkedHashMap::new
				)
			);
	}

	@Override
	public String toString() {
		StringBuilder pontosBuilder = new StringBuilder();
		ponto.forEach((tipoPonto, quantidade) -> {
			pontosBuilder.append(tipoPonto + "=" + quantidade + ";");
		});
		return pontosBuilder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ponto == null) ? 0 : ponto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pontuacao other = (Pontuacao) obj;
		if (ponto == null) {
			if (other.ponto != null)
				return false;
		} else if (ponto.entrySet().stream()
		      .allMatch(e -> e.getValue().equals(other.ponto.get(e.getKey())))) {
			return true;
		} else if (!ponto.equals(other.ponto)) {
			return false;
		}
		return true;
	}
}
