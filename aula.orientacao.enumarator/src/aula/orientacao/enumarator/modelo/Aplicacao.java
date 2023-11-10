package aula.orientacao.enumarator.modelo;

import java.time.Month;

import aula.orientacao.enumarator.persistencia.ClientePersistencia;

public class Aplicacao {

	
	public static void main(String[] args) {

		//Conta Persistencia
		ClientePersistencia cp1 = new ClientePersistencia();
		
		//Cadastro de clientes
		Cliente cl1 = new Cliente("123", "Joaquim");
		Cliente cl2 = new Cliente("446", "Jeroboão");
		
		
		//Cadastro de conta
		Conta co1 = new Conta("2468");
		Conta co2 = new Conta("8966");
		
		
		//Adicionando conta à um cliente
		cl1.adicionarConta(co1);
		cl1.adicionarConta(co2);
		
		//Criar conta e associar ao cliente;
		Conta co3 = new Conta("2780");
		cl2.adicionarConta(co3);
		
		//Realizar depósito de uma dada quantia;
		co1.depositar(670f);
		co2.depositar(330f);
		
		//Realizar saque de uma dada quantia;
		co1.sacar(50f);
		
		//Efetuar transferência de quantia entre contas;
		co1.transferir(70f, co2);
		
		//Imprimir extrato da movimentação financeira com base no mês e ano;
		//co1.extrato(2023, Month.NOVEMBER);
		
		//Consultar saldo;
		System.out.println(co1.getSaldo());
		
		//Atualização das contas
		cl1.atualizarConta(co1);
		cl1.atualizarConta(co2);
		cl2.atualizarConta(co3);
		
		//Salvando clientes ao arquivo clinte persistencia
		cp1.salvarCliente(cl1);
		cp1.salvarCliente(cl2);
		
		//Atualização dos clientes após serem salvas no cliente persistencia
		cp1.atualizarCliente(cl1);
		cp1.atualizarCliente(cl2);
		
		//Consultar balanço das contas (i.e. Caso o cliente tenha mais de uma conta, somar o valores
		//disponíveis em cada conta).
		//Consultando a movimentação feita pelo cliente
		cl1.consularBalanco();
		cl2.consularBalanco();
		
		//Listar os clientes cadastrados;
		System.out.println(cp1.getClientesCadastrados());
		
		//Consultar cliente por CPF;
		System.out.println(cp1.localizarClientePorCPF("123"));
		
		//Remover conta de um dado cliente;
		//cl1.removerConta(co2);
		
		//Remover cliente;
		//cl1.removerCliente(cl2);
		
		//Listar as contas cadastradas do cliente;
		System.out.println(cl1.getConta());
		
	}
}
