package tdd.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class ArmazenamentoTest {
	private Arquivo arquivo;
	@Test
	public void deveArmazenarPontosEstrelaParaUmUsuario() {
		Usuario usuario = new Usuario("Guerra");
		usuario.adicionarPontos("Estrela", 10);
		arquivo = new Arquivo("arquivo");
		arquivo.armazenarPontuacao(usuario);
		Path nomeArquivo = Paths.get("arquivo.txt");
		
		assertTrue(Files.exists(nomeArquivo));
		
	}

	
	
	
}
