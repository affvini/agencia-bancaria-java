package Programa;

import utilitarios.Utils;

public class Conta {

	private static int contadorDeContas = 1;

	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;

	public Conta(Pessoa pessoa) {
		this.numeroConta = Conta.contadorDeContas;
		this.pessoa = pessoa;
		this.updateSaldo();
		Conta.contadorDeContas += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }

	public String toString() {
		return "\nNúmero da Conta: " + this.getNumeroConta() +
			   "\nNome: " + this.pessoa.getNome() +
			   "\nCPF: " + this.pessoa.getCpf() +
		       "\nE-Mail: " + this.pessoa.getEmail() +
		       "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
		       "\n";

	}
	
	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu depósito foi realiado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o depósito.");
		}
	}
	
	public void saque(Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("Seu saque foi realiado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o saque.");
		}
	}

	public void transferir(Conta contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            //this.saldo = this.getSaldo() - valor;
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        }else {
            System.out.println("Não foi possível realizar a tranferência");
			
		}
	}
	
}
