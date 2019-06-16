package tdd.game;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArmazenamentoTest {

	@Test
	public void deveArmazenarPontosEstrelaParaUmUsuario() {
		Armazenamento armazenamento = new Armazenamento();
		String usuario = "Guerra";
		int ponto = 10;
		String tipo = "Estrela";
		
		assertTrue(armazenamento.adicionaPontosUsuario(usuario, ponto, tipo));
				
	}
	
	
	
}
