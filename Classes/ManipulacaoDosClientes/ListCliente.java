/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.ManipulacaoDosClientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author piva
 */
public class ListCliente {
    private static final List<Cliente> listCliente = new ArrayList<>();

    @Override
    public String toString() {
        String str = "";
        
        for (Cliente c : this.listCliente) {
            str += c.toString() + "\n";
        }
        
        return str;
    }
    
    //Método responsável por achar um cliente dentro da lista pelo seu CPF
    public static Cliente findClienteForYourCpf(String cpf) {
        if (!ListCliente.listCliente.isEmpty()) {
            for (Cliente c : ListCliente.listCliente) {
                if (cpf.equals(c.getCpf())) {
                    return c;
                }
            }
        }
        
        return null;
    }
    
    //Método responsaǘel por adicionar um cliente na lista
    static public void add() {
        System.out.println("----- ADICIONANDO UM CLIENTE ------");
        Cliente c = new Cliente();
        c.fill();
        
        if (findClienteForYourCpf(c.getCpf()) != null) {
            System.out.println("ERRO - Já existe um cliente cadastrado com esse CPF!\n");
        } else {
            ListCliente.listCliente.add(c);
            System.out.println("CLIENTE ADICIONADO!\n");
        }
    }
    
    //Método responsável por remover um cliente da lista
    static public void remove() {
        Scanner scan = new Scanner(System.in);
        System.out.println("----- REMOVENDO UM CLIENTE -----");
        String cpfRemovido = Cliente.pegarCpf(scan);
        Cliente removido = findClienteForYourCpf(cpfRemovido);
        
        if (removido != null) {
            ListCliente.listCliente.remove(removido);
            System.out.println("CLIENTE REMOVIDO!\n");
        } else {
            System.out.println("ERRO - Esse cliente não foi cadastrado!\n");
        }
    }
    
    //Método responsáevl por retornar o cliente pelo seu indice
    static public Cliente getForIndex(int index) {
        return listCliente.get(index);
    }
    
    //Método responsável por retornar o tamanho da lista de clientes
    static public int getTam() {
        return listCliente.size();
    }
    
    //Método responsável por mostrar os clientes que mais fizeram pedidos
    static public void printClienteMaisPedidos() {
        Cliente clienteComMaisPedidos = new Cliente();
        int maiorNumPedidos = 0;
        boolean swaped = false;
        
        for (int i = 0; i < ListCliente.getTam(); i++) {
            if (maiorNumPedidos < ListCliente.getForIndex(i).getNumPedidos()) {
                maiorNumPedidos = ListCliente.getForIndex(i).getNumPedidos();
                clienteComMaisPedidos = ListCliente.getForIndex(i);
                swaped = true;
            }
        }
        
        if (swaped) {
            clienteComMaisPedidos.print();
        } else {
            System.out.println("ERRO - Sem pedidos feitos!\n");
        }
    }
    
    //Método responsável por mostrar os clientes que mais gastaram
    public static void printClienteQueMaisGastou() {
        Cliente clienteComMaisGastos = new Cliente();
        double maiorGasto = 0.0;
        boolean swaped = false;
        
        for (int i = 0; i < ListCliente.getTam(); i++) {
            if (maiorGasto < ListCliente.getForIndex(i).getTotalGasto()) {
                maiorGasto = ListCliente.getForIndex(i).getTotalGasto();
                clienteComMaisGastos = ListCliente.getForIndex(i);
                swaped = true;
            }
        }
        
        if (swaped) {
            clienteComMaisGastos.print();
        } else {
            System.out.println("ERRO - Sem pedidos feitos!\n");
        }
    }
    
    
    
    
    
}
