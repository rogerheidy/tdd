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

import org.junit.Before;
import org.junit.Test;

public class ArmazenamentoTest {
	private Arquivo arquivo;
	private Usuario usuario1;
	private Usuario usuario2;
	
	@Before
	public void iniciar() {
		usuario1 = new Usuario("Guerra");
		usuario2 = new Usuario("War");
		arquivo = new Arquivo("arquivo");
	}

	@Test
	public void deveArmazenarPontosEstrelaParaUmUsuario() {
		usuario1.adicionarPontos("Estrela", 10);
		arquivo.armazenarPontuacao(usuario1);
		Path nomeArquivo = Paths.get("arquivo.txt");
		assertTrue(Files.exists(nomeArquivo));
	}
	
	@Test
	public void deveRecuperarQuantidadeDePontosDoUsuario() throws IOException {
		Files.write(Paths.get("arquivo.txt"), Arrays.asList("Guerra:Estrela=10;","War:Estrela=1;"), StandardCharsets.UTF_8);
		Integer valorEsperado = 10;
		assertEquals(arquivo.recuperarPontos("Estrela", "Guerra"), valorEsperado);
	}
	
	@Test
	public void deveRetornarTodosUsuariosComPontos() throws IOException {
		usuario1.adicionarPontos("Estrela", 7);
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
