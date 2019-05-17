package projeto.caixaEletronico;

public class CaixaEletronico {
	private Hardware hardware;
    public CaixaEletronico(Hardware hardware) {
        this.hardware = hardware;
       
    }
	public String logar(){
		  String numeroConta = hardware.pegarNumeroDaContaCartao();
 		  return "Usuário Autenticado";
	  }
}
