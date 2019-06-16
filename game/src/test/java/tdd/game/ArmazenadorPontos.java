package tdd.game;

import java.util.Set;

public interface ArmazenadorPontos {
	void adicionaPontosUsuario(String nomeUsuario, String tipoPontuacao, int pontuacao);
	Set<Ponto> pontosPorUsuario(String nomeUsuario);
}
