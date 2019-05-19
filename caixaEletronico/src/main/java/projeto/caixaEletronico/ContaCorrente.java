package projeto.caixaEletronico;

public class ContaCorrente {
	private String numeroConta;
	private double saldo;

	public ContaCorrente(String numeroConta, double saldo) {
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	 public boolean sacar(double valorASacar) {
	       this.saldo = this.saldo - valorASacar;
	        return true;
	 }

	public String getNumConta() {
		return this.numeroConta;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
		
	}
}
