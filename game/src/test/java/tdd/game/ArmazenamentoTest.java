package tdd.game;

import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class ArmazenamentoTest {
	private Arquivo arquivo;
	

	@Test
	public void deveArmazenarPontosEstrelaParaUmUsuario() {
		Usuario usuario = new Usuario("Guerra");
		usuario.adicionarPontos("Estrela", 10);
		
		arquivo.armazenarPontuacao(usuario);
		Path arquivo = criarPath();
		
		assertThat(usuario.toString(), is(arquivo.recuperarUsuario("Guerra").toString()));
		assertTrue(Files.exists(arquivo));
	}
	
	
	
}
