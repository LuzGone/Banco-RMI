package com.br.luzgone.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF{
    private List<Conta> contas = new ArrayList<Conta>();

    public BancoServiceServer() throws RemoteException {
        contas.add(new Conta("123", 150.36));
        contas.add(new Conta("456", 250.82));
        contas.add(new Conta("789", 350.96));
    }

    @Override
    public void cadastroNovaConta(String numero) throws RemoteException{
        this.contas.add(new Conta(numero, 0.0));
    }

    @Override
    public String pesquisaConta(String numeroConta) throws RemoteException{
        for (Conta conta : this.contas){
            if(conta.getNumero().equals(numeroConta)){
                return conta.toString();
            }
        }
        throw new RemoteException();
    }

    @Override
    public boolean removerConta(String numeroConta) throws RemoteException{
        for (Conta conta : this.contas){
            if(conta.getNumero().equals(numeroConta)){
                return this.contas.remove(conta);
            }
        }
        throw new RemoteException();
    }

    @Override
    public double saldo(String numeroConta) throws RemoteException {
        for (Conta conta : this.contas){
            if(conta.getNumero().equals(numeroConta)){
                return conta.getSaldo();
            }
        }
        throw new RemoteException();
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }


}
