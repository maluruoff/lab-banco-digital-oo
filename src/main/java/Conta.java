import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected List<Transacao> transacoes;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.transacoes = new ArrayList<>();
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
		transacoes.add(new Transacao(new Date(), "saque", valor, saldo));
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		transacoes.add(new Transacao(new Date(), "deposito", valor, saldo));

	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		transacoes.add(new Transacao(new Date(), "transferencia", valor, saldo));
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("Histórico de transações:");
		for (Transacao transacao : transacoes) {
			System.out.println(String.format("%s - %s: %.2f (Saldo: %.2f)", transacao.getData(), transacao.getTipo(), transacao.getValor(), transacao.getSaldoAposTransacao()));
		}
	}
}
