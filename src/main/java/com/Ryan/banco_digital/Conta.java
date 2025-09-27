package com.Ryan.banco_digital;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titular;
    private double saldo;

    public Conta() {}

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
}
