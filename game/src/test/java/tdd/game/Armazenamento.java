package tdd.game;


public interface Armazenamento {

	public void armazenarPontuacao(Usuario usuario);

	public Usuario recuperarUsuario(String nomeUsuario);

}
