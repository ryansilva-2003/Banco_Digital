package com.Ryan.banco_digital.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import static com.Ryan.banco_digital.model.Banco.validarCpf;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		Banco banco = new Banco();
		Scanner scanner = new Scanner(System.in);
		int choice;
		String cpf;

		boolean sair = false;
		Conta contaLogada = null;

		while(!sair) {
			System.out.println("Bem-vindo ao BANCO DIGITAL EM JAVA");
			System.out.println("-----------------------------------");
			System.out.println("1.Cadastrar nova conta");
			System.out.println("2.Entrar em uma conta");
			System.out.println("3.Sair");
			System.out.println("-----------------------------------");
			System.out.println("opção: ");
			int escolha = scanner.nextInt();
			scanner.nextLine();

			switch (escolha) {
				case 1:
					System.out.println("Por favor digite seu nome: ");
					String nome = scanner.nextLine();
					do {
						System.out.println("Por favor digite seu cpf (11 dígitos): ");
						cpf = scanner.nextLine();

						if (!validarCpf(cpf)) {
							System.out.println("Cpf inválido! Tente novamente.");
						}
					} while (!validarCpf(cpf));
					contaLogada = banco.cadastrarConta(nome, cpf);
					break;
				case 2:
					System.out.println("Digite o numero da agência: ");
					int agencia = scanner.nextInt();
					contaLogada = banco.buscarPorAgencia(agencia);
					if (contaLogada == null) {
						System.out.println("Conta não encontrada");
					} else {
						System.out.println("Login realizado com sucesso! Bem-vindo " + contaLogada.getNome());
					}
					break;
				case 3:
					sair = true;
				default:
					System.out.println("---Obrigado por usar o BANCO DIGITAL EM JAVA---");
			}

			while (contaLogada != null) {
				System.out.println("Olá " +contaLogada.getNome()+ " o que quer fazer?");
				System.out.println("---------------------------------");
				System.out.println("1.Saldo atual");
				System.out.println("2.Depósitar");
				System.out.println("3.Sacar");
				System.out.println("4.Transferir para outra conta");
				System.out.println("5.Sair");
				System.out.println("---------------------------------");
				System.out.println("Escolha uma opção: ");
				choice = scanner.nextInt();

				switch (choice) {
					case 1:
						System.out.println("O saldo da conta é: R$" + contaLogada.getSaldo());
						break;
					case 2:
						System.out.println("Valor do depósito: R$");
						double valorDep = scanner.nextDouble();
						contaLogada.depositar(valorDep);
						break;
					case 3:
						System.out.println("Qual será o valor do saque: R$");
						double valorSaq = scanner.nextDouble();
						contaLogada.sacar(valorSaq);
						break;
					case 4:
						System.out.println("Digite o numero da agencia da conta destino:");
						int contaDestino = scanner.nextInt();
						Conta destino = banco.buscarPorAgencia(contaDestino);
						if (destino != null) {
							System.out.println("Digite valor da transferência: R$");
							double valorTraf = scanner.nextDouble();
							contaLogada.transferir(destino, valorTraf);
						} else {
							System.out.println("Conta não encontrada");
						}
						break;
					case 5:
						contaLogada = null;
					default: System.out.println(":)");

				}
			}
		}
			scanner.close();
		}
	}


