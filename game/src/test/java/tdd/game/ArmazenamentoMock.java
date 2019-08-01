package tdd.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmazenamentoMock  implements Armazenamento {
	Map<String, Usuario> usuarios = new HashMap<>();  	
	
	public Integer recuperarPontuacaoUsuario(String tipoPonto, String nomeUsuario) {
		Usuario usuario = this.usuarios.get(nomeUsuario);
		if (null != usuario && null != usuario.getPontuacao()) {
			return usuario.getPontuacao().getPontos(tipoPonto);
		}
		return 0;
	}

	@Override
	public void armazenarPontuacao(Usuario usuario) {
		this.usuarios.put(usuario.getNome(), usuario);
		
	}

	@Override
	public Usuario recuperarUsuario(String nomeUsuario) {
		return this.usuarios.getOrDefault(nomeUsuario, new Usuario(nomeUsuario));
	}
	
	@Override
	public Integer recuperarPontos(String tipoPonto, String nomeUsuario) {
		return null;
	}
	
	@Override
	public List<Usuario> recuperarUsuarios() {
		return new ArrayList<Usuario>(this.usuarios.values());
	}


}
