package aula.orientacao.enumarator.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cpf;
	String nome;
	private ArrayList<Conta> contas = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	
	public Cliente(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}
	
	//Cadastrar cliente;
	public void adicionarConta(Conta c) {
		if(!contas.contains(c))
			contas.add(c);
		else
			System.out.println("Conta cadastrada");
	}
	
	//Remover cliente;
	public void removerCliente(Cliente c) {
		if(clientes.contains(c)) {
			clientes.remove(c);
		}
		else {
			System.out.println("Cliente inexistente");
		}
	}
	
	//Remover conta de um dado cliente;
	public void removerConta(Conta c) {
		if(contas.contains(c))
			contas.remove(c);
		else
			System.out.println("Conta inexistente");
	}
	
	//Consultar balanço das contas (i.e. Caso o cliente tenha mais de uma conta, somar o valores 
	//disponíveis em cada conta).
	public float consularBalanco() {
		float saldoTotal = 0f;
		for(Conta conta : contas) {
			saldoTotal += conta.getSaldo();
		}
		return saldoTotal;
	}
	
	//Listar as contas cadastradas do cliente
	public ArrayList<Conta> getConta(){
		return contas;
	}
	
	public Conta localizarContaPorNumero(String numero) {
		Conta temp = new Conta(numero);
		if(contas.contains(temp)) {
			int index = contas.indexOf(temp);
			temp = contas.get(index);
			return temp;
		}else
			return null;
	}
	
	public void atualizarConta(Conta c) {
		if(contas.contains(c)) {
			int index = contas.indexOf(c);
			contas.set(index, c);
		}else
			System.out.println("Conta não localizada");
	}


	@Override
	public String toString() {
		return "Cliente [cpf:" + cpf + ", nome:" + nome + ", contas:" + contas + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	
	
}
