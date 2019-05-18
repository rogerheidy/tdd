package projeto.caixaEletronico;

public class CaixaEletronico {
	private Hardware hardware;
    public CaixaEletronico(Hardware hardware) {
        this.hardware = hardware;
       
    }
	public String logar(String conta) throws HardwareException{
		  String numeroConta = hardware.pegarNumeroDaContaCartao();
		  if (numeroConta == conta) {
			  return "Usuário Autenticado";
	        }
 		  return "Não foi possível autenticar o usuário";
	  }
	public String saldo(String conta) throws HardwareException{
	return;	
	
}
