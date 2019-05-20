package projeto.caixaEletronico;

public class HardwareMock implements Hardware {

    private String numeroDaContaRetorno = "10010-1";
    private boolean falharHardware = false;
		
	public boolean isFalharHardware() {
		falharHardware = true;
		return falharHardware;
	}

 	    public String pegarNumeroDaContaCartao() throws HardwareException{
	        if(falharHardware)
				throw new HardwareException();
	        return numeroDaContaRetorno;
	    }
 	    
 	   public void entregarDinheiro() throws HardwareException{
	        if(falharHardware)
				throw new HardwareException();
	        
	    }
 	  public void lerEnvelope() throws HardwareException{
 	
 		  if(falharHardware)
				throw new HardwareException();
 		  	
 	  }

}
