package projeto.caixaEletronico;

public interface Hardware {
	public String pegarNumeroDaContaCartao()throws HardwareException;

	public void entregarDinheiro()throws HardwareException;

}
