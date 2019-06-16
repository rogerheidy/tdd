package tdd.game;

public class Placar {
	 private ArmazenadorPontos armazenamento;
	 public Placar(ArmazenadorPontos armazenamento) {
	        this.armazenamento = armazenamento;
	    }

	    public void adicionaPontosUsuario(String nomeUsuario, String tipoPontuacao, int quantidadePontuacao) {
	        this.armazenamento.adicionaPontosUsuario(nomeUsuario, tipoPontuacao, quantidadePontuacao);
	    }

}
