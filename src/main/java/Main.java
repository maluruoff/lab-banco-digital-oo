public class Main {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Maria");
		
		Conta cc = new ContaCorrente(cliente, 1000d);
		Conta poupanca = new ContaPoupanca(cliente);

		cc.depositar(500);
		cc.transferir(250, poupanca);
		cc.transferir(50, poupanca);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
