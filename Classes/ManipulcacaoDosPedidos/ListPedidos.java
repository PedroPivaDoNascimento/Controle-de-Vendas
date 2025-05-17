/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.ManipulcacaoDosPedidos;

import Classes.Utilitarios.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author piva
 */
public class ListPedidos {
    private static final List<Pedidos> listPedidos = new ArrayList();
    
    //Método responsável por achar um pedido pelo seu ID
    public static Pedidos findPedidosForYourId(String idProcurado) {
        if (!ListPedidos.listPedidos.isEmpty()) {
            for (Pedidos p : ListPedidos.listPedidos) {
                if (idProcurado.equals(p.getId())) {
                    return p;
                }
            }
        }
        
        return null;
    }
    
    //Método responsável por adicionar um pedido na lista
    static public void add() {
        System.out.println("----- ADICIONANDO UM PEDIDO ------");
        Pedidos p = new Pedidos();
        p.fill();
        
        if (findPedidosForYourId(p.getId()) != null) {
            System.out.println("ERRO - Já existe um pedido com esse ID!\n");
        } else if (!p.getValido()) {
            System.out.println("ERRO - Esse pedido apresenta algum valor inválido!\n");
        } else {
            int numPedidos = p.getCliente().getNumPedidos();
            p.getCliente().setNumPedidos(numPedidos+1);
            
            double totalGasto = p.getCliente().getTotalGasto();
            double valorPedido = p.getListProduto().valorTotalListProdutos();
            p.getCliente().setTotalGasto(totalGasto + valorPedido);
            
            ListPedidos.listPedidos.add(p);
            System.out.println("PEDIDO ADICIONADO!\n");
        }
    }
    
    //Método responsável por remover um pedido da lista
    static public void remove() {
        Scanner scan = new Scanner(System.in);
        System.out.println("------ REMOVENDO UM PEDIDO -----");
        String idRemovido = Util.pegarId(scan);
        Pedidos removido = findPedidosForYourId(idRemovido);
        
        if (removido != null) {
            int numPedidos = removido.getCliente().getNumPedidos();
            removido.getCliente().setNumPedidos(numPedidos -1);
            
            double totalGasto = removido.getCliente().getTotalGasto();
            double valorPedido = removido.getListProduto().valorTotalListProdutos();
            removido.getCliente().setTotalGasto(totalGasto - valorPedido);
            
            removido.removeAllProdutos(scan);
            
            ListPedidos.listPedidos.remove(removido);
            System.out.println("PEDIDO REMOVIDO!\n");
        } else {
            System.out.println("ERRO - Esse pedido não foi cadastrado!\n");
        }
    }
    
    //Método responsável retornar a quantidade total de pedidos na lista
    public static int getTam() {
        return ListPedidos.listPedidos.size();
    }
    
    //Método responsável retornar o faturamento total de todos os pedidos
    public static double getFaturamentoTot() {
        double somaTotal = 0.0;
        
        for (Pedidos p : ListPedidos.listPedidos) {
            somaTotal += p.getValotTot();
        }
        
        return somaTotal;
    }
}
