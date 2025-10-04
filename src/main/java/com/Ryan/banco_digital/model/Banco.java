package com.Ryan.banco_digital.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banco {

    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public Conta cadastrarConta(String nome, String cpf) {
        if (!validarCpf(cpf)){
            System.out.println("O cpf tem que ter 11 dígitos numéricos");
            return null;
        }
        int agencia = gerarAgencia();
        Conta conta = new Conta(nome, cpf, agencia);
        contas.add(conta);
        System.out.println("Conta cadastrada com sucesso! Número: " + agencia);
        return conta;
    }

    public static boolean validarCpf(String cpf){
        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf.matches("\\d{11}");
    }

    public Conta buscarPorNumero(int agencia) {
        for (Conta c : contas) {
            if (c.getAgencia() == agencia) {
                return c;
            }
        }
        return null;
    }

    private int gerarAgencia() {
    Random random = new Random();
    int number;
    do
    {
         number = random.nextInt(9000) + 1000;
    } while(buscarPorNumero(number) != null);
    return number;

}
}
