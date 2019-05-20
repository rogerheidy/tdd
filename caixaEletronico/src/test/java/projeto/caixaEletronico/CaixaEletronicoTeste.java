package projeto.caixaEletronico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CaixaEletronicoTeste {
	HardwareMock hardware;
	ServicoRemotoMock servico;
	CaixaEletronico caixa;
	ContaCorrente conta, contaErrada;
	
	@Before
	public void inicializa() {
		hardware = new HardwareMock();
		servico = new ServicoRemotoMock();
		caixa = new CaixaEletronico(hardware, servico);
		conta = new ContaCorrente("10010-1", 1000);
		contaErrada = new ContaCorrente("10010-2", 4000);
		
	}


	@Test
	public void deveLogarComSucesso() throws HardwareException {
		
		assertEquals(conta.getNumConta(),hardware.pegarNumeroDaContaCartao());
		assertEquals("Usuário Autenticado", caixa.logar(conta.getNumConta()));
	}

	
	@Test
	public void deveLogarComFalha() throws HardwareException {
		assertNotEquals(contaErrada.getNumConta(),hardware.pegarNumeroDaContaCartao());
		assertEquals("Não foi possível autenticar o usuário", caixa.logar(contaErrada.getNumConta()));
	}

	@Test
	public void deveFalharHardware() throws HardwareException {
		assertTrue(hardware.isFalharHardware());
		
		}
	
	@Test
	public void deveMostrarSaldo()throws HardwareException {
		assertEquals("O saldo é R$1000.0", caixa.saldo(conta.getNumConta()));
	}
	
	@Test
	public void contaNaoEncontrada()throws HardwareException {
		assertEquals("Conta não encontrada", caixa.saldo(contaErrada.getNumConta()));
	}
	
	@Test
	public void deveSacar() throws HardwareException{
		assertEquals(caixa.sacar(conta.getNumConta(), 100), "Retire seu dinheiro");
	}
	
	@Test
	public void saldoInsuficiente() throws HardwareException{
		assertEquals(caixa.sacar(conta.getNumConta(), 2000), "Saldo insuficiente");
	}
	

}
