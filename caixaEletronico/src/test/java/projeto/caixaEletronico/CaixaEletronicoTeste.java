package projeto.caixaEletronico;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaixaEletronicoTeste {

	@Test
	public void deveLogarComSucesso() {
		CaixaEletronico caixa = new CaixaEletronico();
		assertEquals("Usuário Autenticado", caixa.logar());
	}

}
