package com.br.luzgone.banco;

import java.io.Serializable;

public class Conta implements Serializable{
    private String numero;
    private Double saldo;

    public Conta(String numero, Double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double creditar(Double valor){
        this.saldo+= valor;
        return this.saldo;
    }

    public Double debitar(Double valor) throws Exception{
        if(valor<this.saldo){
            this.saldo -= valor;
            return this.saldo; 
        }else{
            throw new Exception("Saldo Insuficiente");
        }
    }

    @Override
    public String toString(){
        String saida = "Conta: "+ this.numero + "\nSaldo : R$" + this.saldo;
        return saida;
    }
}
