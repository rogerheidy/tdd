package projeto.caixaEletronico;

public class ServicoRemotoMock implements ServicoRemoto {
    private String numeroConta= "10010-1";
    private double saldo = 1000.0;
    private ContaCorrente contaCorrenteRetornada;
    

    public ContaCorrente recuperarConta(String conta) {
               
    	if (this.numeroConta == conta) {
    		contaCorrenteRetornada = new ContaCorrente(numeroConta, saldo);
        	return contaCorrenteRetornada;
        }

        return null;
    }

}