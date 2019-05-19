package projeto.caixaEletronico;

public interface ServicoRemoto {
	public ContaCorrente recuperarConta(String numConta);

	public void persistirConta(ContaCorrente contaCorrente);

	
}
