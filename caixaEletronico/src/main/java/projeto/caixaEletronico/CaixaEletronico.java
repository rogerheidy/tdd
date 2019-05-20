package projeto.caixaEletronico;

public class CaixaEletronico {
	private Hardware hardware;
    private ServicoRemoto servicoRemoto;
    private ContaCorrente contaCorrente;
    
    public CaixaEletronico(Hardware hardware, ServicoRemoto servico) {
        this.hardware = hardware;
        this.servicoRemoto = servico;
       
    }
	public String logar(String conta) throws HardwareException{
		  String numeroConta = hardware.pegarNumeroDaContaCartao();
		  if (numeroConta == conta) {
			  return "Usuário Autenticado";
	        }
 		  return "Não foi possível autenticar o usuário";
	  }
	public String saldo(String conta) throws HardwareException{
		contaCorrente = servicoRemoto.recuperarConta(conta);
			if(contaCorrente != null)
				return "O saldo é R$" + contaCorrente.getSaldo();
			return "Conta não encontrada";
		}
	public String sacar(String conta, double valor) throws HardwareException {
        contaCorrente = servicoRemoto.recuperarConta(conta);
        if (contaCorrente == null) {
           	return "Conta não encontrada";
        }
        if((contaCorrente.getSaldo() - valor) >= 0) {
            contaCorrente.sacar(valor);
        	servicoRemoto.persistirConta(contaCorrente);
            hardware.entregarDinheiro();
            return "Retire seu dinheiro";
        }
        return "Saldo insuficiente";
    }
	public Object depositar(String numConta, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
