package tdd.game;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Arquivo {
	private Path arquivo;
	
	public Arquivo(String nomeArquivo) {
		this.arquivo = Paths.get(nomeArquivo + ".txt");
	}

	public void armazenarPontuacao(Usuario usuario) {
		try {
			if (Files.exists(arquivo)) {
				List<String> dados;
				
				dados = new ArrayList<>(Files.readAllLines(arquivo, StandardCharsets.UTF_8));
				
				alterarRegistroUsuarioExistente(usuario, dados);
				salvarArquivo(dados);
			} else {
				salvarArquivo(Arrays.asList(usuario.toString()));
			}
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	private void salvarArquivo(List<String> dados) {
		try {
			Files.write(this.arquivo, dados, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void alterarRegistroUsuarioExistente(Usuario usuario, List<String> dados) {
		boolean usuarioNovo = true;
		for (int i = 0; i < dados.size() ; i++) {
			if (this.extrairUsuario(dados.get(i)).equalsIgnoreCase(usuario.getNome())) {
				dados.set(i, usuario.toString());
				usuarioNovo = false;
				break;
			}
		}
		if (usuarioNovo) {
			dados.add(usuario.toString());
		}
	}
	
	private String extrairUsuario(String registro) {
		try {
			return separarUsuarioDePontuacao(registro)[0];
		} catch (Exception e) {
			throw e;
		}
	}
	
	private String[] separarUsuarioDePontuacao(String registro) {
		return registro.split(":");
	}
	
	public Usuario recuperarUsuario(String nomeUsuario) {
		List<Usuario> usuarios = this.recuperarUsuarios();
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equalsIgnoreCase(nomeUsuario)) return usuario;
		}
		return new Usuario(nomeUsuario);
	}
	public List<Usuario> recuperarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		if (Files.exists(arquivo)) {
			try {
				List<String> pontosUsuario = Files.lines(arquivo, StandardCharsets.UTF_8).collect(Collectors.toList());
				for (String registro : pontosUsuario) {				
					usuarios.add(criarUsuario(extrairUsuario(registro), separarTipo(registro)));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}

	private Usuario criarUsuario(String nomeUsuario, String[] pontuacaoPorTipo) {
		Usuario usuario = new Usuario(nomeUsuario);
		for (String item : pontuacaoPorTipo) {
			String tipoPonto = recuperarTipoPonto(item);
			Integer quantidadePontos = recuperarQuantidade(item);
			usuario.adicionarPontos(tipoPonto, quantidadePontos);
		}
		return usuario;
	}

	private String[] separarTipo(String registro) {
		return extrairTodasPontuacoes(registro).split(";");
	}
	
	private String recuperarTipoPonto(String tipoPonto) {
		return tipoPonto.split("=")[0];
	}
	
	private Integer recuperarQuantidade(String quantidadePontos) {
		return Integer.valueOf(quantidadePontos.split("=")[1]);
	}

	public Integer recuperarPontos(String tipoPonto, String nomeUsuario) {
		Usuario usuario = this.recuperarUsuario(nomeUsuario);
		return usuario.getPontos(tipoPonto);
	}

	private String extrairTodasPontuacoes(String registro) {
		try {
			return separarUsuarioDePontuacao(registro)[1];
		} catch (Exception e) {
			throw e;
			
		}
		
	}
}
