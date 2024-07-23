import java.util.Date;

public class ContaCorrente extends Conta {

	private double limiteCredito;

	public ContaCorrente(Cliente cliente, double limiteCredito) {
		super(cliente);
		this.limiteCredito = limiteCredito;
	}

	@Override
	public void sacar(double valor) {
		if (saldo + limiteCredito >= valor) {
			saldo -= valor;
			transacoes.add(new Transacao(new Date(), "saque", valor, saldo));
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}
