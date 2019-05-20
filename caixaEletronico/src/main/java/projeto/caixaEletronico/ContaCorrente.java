package projeto.caixaEletronico;

public class ContaCorrente {
	private String numeroConta;
	private double saldo;

	public ContaCorrente(String numeroConta, double saldo) {
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	 public void sacar(double valorASacar) {
	       this.saldo = this.saldo - valorASacar;
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

	public void depositar(double valorDeposito) {
		this.saldo = this.saldo + valorDeposito;
		
	}
}
