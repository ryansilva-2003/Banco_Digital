package com.Ryan.banco_digital.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banco {

    private List<Conta> contas;

    public Banco(){
        this.contas = new ArrayList<>();
    }

    public Conta cadastrarConta(String nome, String cpf){
        int agencia = gerarAgencia();
        Conta conta = new Conta(nome, cpf, agencia);
        contas.add(conta);
        System.out.println("Conta cadastrada com sucesso! Número: " + agencia);
        return conta;
    }
    public Conta buscarPorAgencia(int agencia) {
        for (Conta c : contas) {
            if (c.getAgencia() == agencia) {
                return c;
            }
        }
        return null;
    }
    private int gerarAgencia() {
        Random random = new Random();
        int numero;
        do {
            numero = random.nextInt(9000) + 1000;
        } while (buscarPorAgencia(numero) != null);
        return numero;
    }
}
