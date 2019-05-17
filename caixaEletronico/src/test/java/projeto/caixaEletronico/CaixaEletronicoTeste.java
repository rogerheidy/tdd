package projeto.caixaEletronico;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaixaEletronicoTeste {

	@Test
	public void deveLogarComSucesso() {
		HardwareMock hardware = new HardwareMock();
		CaixaEletronico caixa = new CaixaEletronico(hardware);
		assertEquals("10010-1",hardware.pegarNumeroDaContaCartao());
		assertEquals("Usuário Autenticado", caixa.logar());
	}

	
	
}
