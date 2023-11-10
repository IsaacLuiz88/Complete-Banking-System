package aula.orientacao.enumarator.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Objects;

public class Conta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numero;
	float saldo;
	LocalDateTime dataAbertura;
	boolean status;
	
	private ArrayList<Transacao> transacoes = new ArrayList<>();
	private ArrayList<Conta> contas = new ArrayList<>();
	
	
	public Conta(String numero) {
		super();
		this.numero = numero;
		this.saldo = 0f;
		this.dataAbertura = LocalDateTime.now();
		this.status = true;
	}	
	
	//Realizar depósito de uma dada quantia;
	public void depositar(float quantia) {
		if(status && quantia > 0) {
			saldo += quantia;
			transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.CREDITO));
		}
		else
			System.out.println("Deposito não realizado");
	}
	
	//Consultar saldo;
	public float getSaldo() {
		return saldo;
	}
	
	//Realizar saque de uma dada quantia;
	public void sacar(float quantia) {
		if(status && quantia > 0 && quantia <= saldo) {
			saldo -= quantia;
			transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.DEBITO));
		}
		else
			System.out.println("Operacao nao pode ser realizada");
	}
	
	//Imprimir extrato da movimentação financeira com base no mês e ano;
	public void extrato(int year, Month month) {
		for(Transacao t : transacoes) {
			if(t.dataTransacao.getYear() == year && t.dataTransacao.getMonth() == month) {
				System.out.println(t);
			}
		}
	}
	
	//Efetuar transferência de quantia entre contas;
	public void transferir(float quantia, Conta contaDestino) {
		if (this.status && contaDestino.status && quantia > 0 && quantia <= this.saldo) {
			this.saldo -= quantia;
			contaDestino.saldo += quantia;
			this.transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.TRANSFERENCIA_DEBITO, contaDestino));
			contaDestino.transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.TRANSFERENCIA_CREDITO, this));
		}
	}
	
	public static void transferir(float quantia, Conta origem, Conta destino) {
		if (origem.status && destino.status && quantia > 0 && quantia <= origem.saldo) {
			origem.saldo -= quantia;
			destino.saldo += quantia;
			origem.transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.TRANSFERENCIA_DEBITO, destino));
			destino.transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.TRANSFERENCIA_CREDITO, origem));
		}
	}
	
		@Override
	public String toString() {
		return "Conta [numero:" + numero + ", saldo:" + saldo + ", dataAbertura:" + dataAbertura + ", status:" + status
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(numero, other.numero);
	}
}
