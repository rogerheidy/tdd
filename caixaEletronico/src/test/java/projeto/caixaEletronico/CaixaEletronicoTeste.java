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
	public void deveLogarComSucesso()  {
		assertEquals("Usuário Autenticado", caixa.logar());
		assertTrue(hardware.chamouPegarNumeroDaContaCartao);
	}

	
	@Test
	public void deveLogarComFalha()  {
		hardware.isFalharHardware();
		assertTrue(hardware.isFalharHardware());
		assertEquals("Não foi possível autenticar o usuário", caixa.logar());
		assertTrue(hardware.chamouPegarNumeroDaContaCartao);
	}


	@Test
	public void deveMostrarSaldo() {
		assertEquals("O saldo é R$1000.0", caixa.saldo(conta.getNumConta()));
	}
	
	@Test
	public void contaNaoEncontrada() {
		assertEquals("Conta não encontrada", caixa.saldo(contaErrada.getNumConta()));
	}
	
	@Test
	public void deveSacar() {
		assertEquals("Retire seu dinheiro", caixa.sacar(conta.getNumConta(), 100));
	}
	
	@Test
	public void saldoInsuficiente() {
		assertEquals("Saldo insuficiente", caixa.sacar(conta.getNumConta(), 2000));
	}
	
	@Test
	public void depositar() {
		assertEquals("Depósito recebido com sucesso", caixa.depositar(conta.getNumConta(), 100));
	}
	

}
