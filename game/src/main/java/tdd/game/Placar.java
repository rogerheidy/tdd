package tdd.game;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

		public Pontuacao recuperarPontuacaoUsuario(String nome) {
			Usuario usuario = armazenamento.recuperarUsuario(nome);
			return usuario.getPontuacao();
		}

		public Map<String, Integer> recuperarRanking(String tipoPonto) {
			List<Usuario> usuarios = armazenamento.recuperarUsuarios();
			
			Comparator<Usuario> usuarioComparator = (Usuario u1, Usuario u2) -> u1.getPontos(tipoPonto)-u2.getPontos(tipoPonto);
			
			usuarios = usuarios.stream()
					.filter( u -> u.getPontos(tipoPonto) > 0 )
					.sorted(usuarioComparator.reversed())
					.collect(Collectors.toList());
			
			Map<String, Integer> ranking = new LinkedHashMap<>();
			usuarios.forEach( u -> {
				ranking.put(u.getNome(), u.getPontos(tipoPonto));
			});
			
			return ranking;
		}


		
		

}
