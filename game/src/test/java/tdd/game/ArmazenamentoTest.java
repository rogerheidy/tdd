package tdd.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	@Test
	public void deveRecuperarQuantidadeDePontosDoUsuario() throws IOException {
		arquivo = new Arquivo("arquivo");
		Files.write(Paths.get("arquivo.txt"), Arrays.asList("Guerra:Estrela=10;","War:Estrela=1;"), StandardCharsets.UTF_8);
		Integer valorEsperado = 10;
		assertEquals(arquivo.recuperarPontos("Estrela", "Guerra"), valorEsperado);
	}
	
	@Test
	public void deveRetornarTodosUsuariosComPontos() throws IOException {
		arquivo = new Arquivo("arquivo");	
		Usuario usuario1 = new Usuario("Guerra");
		usuario1.adicionarPontos("Estrela", 7);
		Usuario usuario2 = new Usuario("War");
		usuario2.adicionarPontos("Estrela", 1);
		usuario2.adicionarPontos("Moeda", 4);
		
		List<Usuario> resultadoEsperado = new ArrayList<>();
		resultadoEsperado.add(usuario1);
		resultadoEsperado.add(usuario2);
		
		criarArquivo(Arrays.asList("Guerra:Estrela=7;","War:Estrela=1;Moeda=4;"));
		
		List<Usuario> resultadoObtido = arquivo.recuperarUsuarios();		
		assertEquals(resultadoObtido.toString(), resultadoEsperado.toString());
	}
	
	
	@Test
	public void deveRecuperarPontuacaoUsuario() throws IOException {
		arquivo = new Arquivo("arquivo");
		Usuario resultadoEsperado = new Usuario("War");
		resultadoEsperado.adicionarPontos("Estrela", 1);
		resultadoEsperado.adicionarPontos("Moeda", 4);
		
		criarArquivo(Arrays.asList("Guerra:Estrela=7;","War:Estrela=1;Moeda=4;"));
		assertEquals(arquivo.recuperarUsuario("War").toString(), resultadoEsperado.toString());
	}
	
	private void criarArquivo(List<String> conteudoDoArquivo) throws IOException {
		Files.write(Paths.get("arquivo.txt"), conteudoDoArquivo, StandardCharsets.UTF_8);
	}
	
	

	
	
	
}
