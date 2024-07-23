import java.util.Date;

public class ContaPoupanca extends Conta {

	private static final double TAXA_JUROS = 0.005;

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	public void aplicarJuros() {
		double juros = saldo * TAXA_JUROS;
		saldo += juros;
		transacoes.add(new Transacao(new Date(), "juros", juros, saldo));
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
	}
}
