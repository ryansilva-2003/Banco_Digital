package com.Ryan.banco_digital.model;

import jakarta.persistence.Entity;

@Entity
public class Conta {

    private String nome;
    private String cpf;
    private int agencia;
    private Double saldo;

    public Conta(String nome, String cpf, int agencia){
        this.nome = nome;
        this.cpf = cpf;
        this.agencia = agencia;
        this.saldo = 0.0;
    }
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public int getAgencia(){
        return agencia;
    }
    public double getSaldo(){
        return saldo;
    }

    public boolean depositar(double valor) {
        if (valor < 0) {
            System.out.println("Depósito não pode ser negativo.");
            return false;
        } else {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " concluído.");
            return true;
        }
    }
    public boolean sacar(double valor){
        if(this.saldo >= valor){
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " foi realizado com sucesso.");
            return true;
        }
        else{
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }
    public boolean transferir(Conta destino, double valor){
        if(this.saldo >= valor){
            saldo -= valor;
            destino.saldo += valor;
            System.out.println("Transferência no valor de R$" + valor + " para " + destino.getNome() + " foi realizado com sucesso");
            return true;
        }
        else{
            System.out.println("Transferência incapaz de ser continuada");
            return false;
        }
    }
}
