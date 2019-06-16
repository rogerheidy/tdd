package tdd.game;

import java.util.Set;
import java.util.stream.Collectors;

public class Placar {
	 private ArmazenadorPontos armazenamento;
	 public Placar(ArmazenadorPontos armazenamento) {
	        this.armazenamento = armazenamento;
	    }

	    public void adicionaPontosUsuario(String nomeUsuario, String tipoPontuacao, int quantidadePontuacao) {
	        this.armazenamento.adicionaPontosUsuario(nomeUsuario, tipoPontuacao, quantidadePontuacao);
	    }


		public Set<Ponto> pontosPorUsuario(String nomeUsuario) {
	        return armazenamento.pontosPorUsuario(nomeUsuario).stream()
	                .filter(ponto -> ponto.getQuantidade() > 0)
	                .collect(Collectors.toSet());
	    }
		

}
