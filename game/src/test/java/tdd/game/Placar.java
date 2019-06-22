package tdd.game;

import java.util.Set;
import java.util.stream.Collectors;

public class Placar {
	 private Armazenamento armazenamento;
	 public Placar(Armazenamento armazenamento) {
	        this.armazenamento = armazenamento;
	    }

	    public void adicionaPontosUsuario(String nomeUsuario, String tipoPontuacao, int quantidadePontuacao) {
	    	Usuario usuario = armazenamento.recuperarUsuario(nomeUsuario);
	    	usuario.adicionarPontos(tipoPontuacao, quantidadePontuacao);
	    	armazenamento.armazenarPontuacao(usuario);
	    }


		
		

}
