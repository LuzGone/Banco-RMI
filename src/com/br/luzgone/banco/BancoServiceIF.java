package com.br.luzgone.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    double saldo(String numeroConta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    void cadastroNovaConta(String numeroConta) throws RemoteException;
    String pesquisaConta(String numeroConta) throws RemoteException;
    boolean removerConta(String numeroConta) throws RemoteException;
}
