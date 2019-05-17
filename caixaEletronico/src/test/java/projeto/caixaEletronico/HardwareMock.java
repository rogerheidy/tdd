package projeto.caixaEletronico;

public class HardwareMock implements Hardware {

    private String numeroDaContaRetorno = "10010-1";


 	    public String pegarNumeroDaContaCartao() {
	        return numeroDaContaRetorno;
	    }


}
