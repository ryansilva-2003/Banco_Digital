package com.Ryan.banco_digital.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BancoDigitalApplication {
	public static void main(String[] args) {
		Banco banco = new Banco();
		Scanner scanner = new Scanner(System.in);
		int choice;

		System.out.println("Bem vindo ao Banco Digital em JAVA");
		System.out.println("-----------------------------------");
		System.out.println("Por favor digite seu nome");
		String nome = scanner.nextLine();
		System.out.println("Por favor digite seu cpf");
		String cpf = scanner.nextLine();

		Conta contaLogada = banco.cadastrarConta(nome,cpf);

		do {
			System.out.println("Escolha uma opção");
			System.out.println("---------------------------------");
			System.out.println("1.Mostrar saldo");
			System.out.println("2.Depósitar");
			System.out.println("3.Sacar");
			System.out.println("4.Transferir para outra conta");
			System.out.println("5.Sair");
			System.out.println("---------------------------------");

			choice = scanner.nextInt();

			switch (choice) {
				case 1:
					System.out.println("O saldo da conta é: R$ " + contaLogada.getSaldo());
					break;
				case 2:
					System.out.println("Valor do depósito: R$ ");
					double valorDep = scanner.nextDouble();
					contaLogada.depositar(valorDep);
					break;
				case 3:
					System.out.println("Qual será o valor do saque: R$ ");
					double valorSaq = scanner.nextDouble();
					contaLogada.sacar(valorSaq);
					break;
				case 4:
					System.out.println("Digite o numero da agencia da conta destino: ");
					int contaDestino = scanner.nextInt();
					Conta destino = banco.buscarPorNumero(contaDestino);
					if (destino != null) {
						System.out.println("Digite valor da transferência: R$ ");
						double valorTraf = scanner.nextDouble();
						contaLogada.transferir(destino, valorTraf);
					} else {
						System.out.println("Conta não encontrada");
					}

			}
		}while (choice != 5);
		System.out.println("Tenha um bom dia!");

		scanner.close();
	}

}
