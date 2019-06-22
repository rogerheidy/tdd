package tdd.game;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arquivo {
	private Path arquivo;

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
			
			
		}
		
	}
	private void salvarArquivo(List<String> dados) {
		try {
			Files.write(this.arquivo, dados, StandardCharsets.UTF_8);
		} catch (IOException e) {

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
	
}
