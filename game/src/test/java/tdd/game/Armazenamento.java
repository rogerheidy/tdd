package tdd.game;

import java.util.List;

public interface Armazenamento {

	public void armazenarPontuacao(Usuario usuario);

	public Usuario recuperarUsuario(String nomeUsuario);

	public List<Usuario> recuperarUsuarios();
	
	public Integer recuperarPontos(String tipoPonto, String nomeUsuario);

}
