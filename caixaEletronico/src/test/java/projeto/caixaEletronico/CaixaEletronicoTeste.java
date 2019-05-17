package projeto.caixaEletronico;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaixaEletronicoTeste {

	@Test
	public void deveLogarComSucesso() {
		String conta = "10010-1";
		HardwareMock hardware = new HardwareMock();
		CaixaEletronico caixa = new CaixaEletronico(hardware);
		assertEquals(conta,hardware.pegarNumeroDaContaCartao());
		assertEquals("Usuário Autenticado", caixa.logar(conta));
	}

	
	@Test
	public void deveLogarComFalha() {
		String conta = "10010-2";
		HardwareMock hardware = new HardwareMock();
		CaixaEletronico caixa = new CaixaEletronico(hardware);
		assertNotEquals(conta,hardware.pegarNumeroDaContaCartao());
		assertEquals("Não foi possível autenticar o usuário", caixa.logar(conta));
	}
}
