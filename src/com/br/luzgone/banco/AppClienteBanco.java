package com.br.luzgone.banco;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o serviço no RMI Registry local. Perceba que o cliente não connhece a implementação do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry();
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Consulta de Saldo de Conta");
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.saldo(conta));
                    System.out.println("\n================================");
                    break;
                }
                case 2: {
                    System.out.println("Quantidade de Contas Cadastradas: ");
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println("-> " + banco.quantidadeContas());
                    System.out.println("\n================================");
                    break;
                }
                case 3: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println("Cadastrando nova conta\nDigite o número da conta: ");
                    String numeroConta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    banco.cadastroNovaConta(numeroConta);
                    System.out.println("Conta criada com Sucesso.");
                    System.out.println("\n================================");
                    break;
                }
                case 4: {
                    System.out.println("Digite o número da conta:");
                    String numeroConta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.pesquisaConta(numeroConta));
                    System.out.println("\n================================");
                    break;
                }
                case 5: {
                    System.out.println("Digite o número da conta:");
                    String numeroConta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    if (banco.removerConta(numeroConta)) {
                        System.out.println("Conta removida com Sucesso");
                    } else{
                        System.out.println("Conta não encontrada");
                    }
                    System.out.println("\n================================");
                    break;
                }

                default:{
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
        entrada.close();
    }

    public static void menu() {
        System.out.println("\n====== BANCO RMI (ou FMI?!) =====");
        System.out.println("\n=== LUIZ GONZAGA DE LIMA NETO ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Cadastrar conta");
        System.out.println("4 - Procurar conta");
        System.out.println("5 - Remover conta");
        System.out.println("9 - Sair");
    }
}
