package tdd.game;

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

		public Pontuacao recuperarPontuacaoUsuario(String nome) {
			Usuario usuario = armazenamento.recuperarUsuario(nome);
			return usuario.getPontuacao();
		}


		
		

}
