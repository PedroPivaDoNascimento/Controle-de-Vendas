/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.ManipulcacaoDosPedidos;

import Classes.ManipulacaoDosClientes.Cliente;
import Classes.ManipulacaoDosClientes.ListCliente;
import Classes.ManipulacaoDosProdutos.Estoque;
import Classes.ManipulacaoDosProdutos.Produto;
import Classes.ManipulacaoDosProdutos.ListProduto;
import Classes.Utilitarios.Util;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author piva
 */
public class Pedidos {
    private Cliente cliente;
    private ListProduto listProduto;
    private String id;
    private boolean valido;

    public Pedidos() {
        this.cliente = new Cliente();
        this.listProduto = new ListProduto();
        this.id = " ";
        this.valido = false;
    }
    public Pedidos(Cliente cliente, ListProduto listProduto, String id, boolean valido) {
        this.cliente.copy(cliente);
        this.listProduto.copy(listProduto);
        this.id = id;
        this.valido = valido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ListProduto getListProduto() {
        return listProduto;
    }

    public void setListProduto(ListProduto listProduto) {
        this.listProduto = listProduto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.cliente);
        hash = 53 * hash + Objects.hashCode(this.listProduto);
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + (this.valido ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedidos other = (Pedidos) obj;
        if (this.valido != other.valido) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return Objects.equals(this.listProduto, other.listProduto);
    }

    @Override
    public String toString() {
        return  "ID: "+ this.id + "\n" + 
                "Clientes:\n" + this.cliente.toString() +
                "Lista de produtos:\n" + this.listProduto.toString();
    }
    
    //Método responsável por pegar o cliente do pedido
    private Cliente pegarCliente(Scanner scan) {
        String cpf = Cliente.pegarCpf(scan);
        Cliente c = ListCliente.findClienteForYourCpf(cpf);
        
        if (c != null) {
            return c;
        }
        
        System.out.println("ERRO - Não existe esse cliente registrado!\n");
        return null;
        
    }
    
    //Método responsável por pegar e adicionar a lista de produtos no cliente
    public void adicionarProdutos(int quant, Scanner scan) {
        for (int i = 0; i < quant; i++) {
            String idProduto = Util.pegarId(scan);
            Produto produto = Estoque.findProdutoForYourId(idProduto);
            
            if (produto != null) {
                int vezesCompradas = produto.getVezesCompradas();
                produto.setVezesCompradas(vezesCompradas + 1);
                
                this.listProduto.add(produto);
                System.out.println("PRODUTO ADICIONADO!\n");
                this.valido = true;
            } else {
                System.out.println("ERRO - Esse produto não esta armazenado no estoque\n");
            } 
        }
        
    }
    //Método responsável por pegar e remover a lista de produtos do cliente
    public void removeAllProdutos(Scanner scan) { 
        for (Produto p : this.listProduto.getListProduto()) {
            if (p != null) {
                if (p.getVezesCompradas() > 0) {
                    int vezesCompradas = p.getVezesCompradas();
                    p.setVezesCompradas(vezesCompradas - 1);
                }
            } else {
                System.out.println("ERRO - Esse produto não esta armazenado no estoque\n");
            } 
        }
    }
    
    //Método responsável pelo preenchimento do pedido
    public void fill() {
        Scanner scan = new Scanner(System.in);
        System.out.println("------ PREENCHENDO OS DADOS DO PEDIDO ------");
        
        int quantidade = Util.pegarQuantidade(scan);
        this.id = Util.pegarId(scan);
        this.cliente = pegarCliente(scan);
        
        if (cliente != null) {
            adicionarProdutos(quantidade, scan);
        } else {
            this.valido = false;
            System.out.println("ERRO - Não foi possível adicionar o cliente!\n");
        }
    }
    
    
    //Método responsável por copiar um pedido para o outro
    public void copy(Pedidos orig) {
        this.cliente.copy(orig.getCliente());
        this.id = orig.getId();
        this.listProduto.copy(orig.getListProduto());
        this.valido = orig.getValido();
    } 
    
    //Método responsável por retornar o valor total desses pedidos
    public double getValotTot() {
        double somaTot = 0.0;
        
        for (Produto p : this.listProduto.getListProduto()) {
            somaTot += p.getPreco();
        }
        
        return somaTot;
    }
    
    
    
    
    
    
}
