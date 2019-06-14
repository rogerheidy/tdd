package projeto.caixaEletronico;

public class HardwareMock implements Hardware {

    private String numeroDaContaRetorno = "10010-1";
    private boolean falharHardware = false;
	public boolean chamouPegarNumeroDaContaCartao = false;
		
	public boolean isFalharHardware() {
		falharHardware = true;
		return falharHardware;
	}

 	    public String pegarNumeroDaContaCartao() {
	    	chamouPegarNumeroDaContaCartao = true;
 			if (falharHardware) throw new RuntimeException();
 			return numeroDaContaRetorno;
 	    }
 	    
 	   public void entregarDinheiro(){
 		  if (falharHardware) throw new RuntimeException();
	        
	    }
 	  public void lerEnvelope(){
 	 		 if (falharHardware) throw new RuntimeException();
 		  	
 	  }

}
