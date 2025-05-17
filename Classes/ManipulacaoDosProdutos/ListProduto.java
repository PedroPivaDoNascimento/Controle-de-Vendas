/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.ManipulacaoDosProdutos;

import Classes.Utilitarios.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author piva
 */
public class ListProduto {
    private List<Produto> listProduto;

    public ListProduto() {
        this.listProduto = new ArrayList<>();
    }
    public ListProduto(List<Produto> listProduto) {
        for (Produto p : listProduto) {
            this.listProduto.add(p);
        }
    }

    public List<Produto> getListProduto() {
        return listProduto;
    }

    public void setListProduto(List<Produto> listProduto) {
        this.listProduto.clear();
        
        for (Produto p : listProduto) {
            this.listProduto.add(p);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.listProduto);
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
        final ListProduto other = (ListProduto) obj;
        return Objects.equals(this.listProduto, other.listProduto);
    }

    @Override
    public String toString() {
        String str = "";
        
        for (Produto p : this.listProduto) {
            str += p.toString() + "\n";
        }
        
        return str;
    }
    
    
    //Função responsável por retornar um produto pelo seu ID
    Produto findProdutoForYourId(String idProcurado) {
        if (!this.listProduto.isEmpty()) {
            for (Produto p : this.listProduto) {
                if (idProcurado.equals(p.getId())) {
                    return p;
                }
            }
        }
        
        return null;
    }
    
    //Método responsável por adicionar um novo produto na lista
    public void add() {
        Produto p = new Produto();
        p.fillEstoque();
        
        if (findProdutoForYourId(p.getId()) != null) {
            System.out.println("ERRO - O ID desse produto já foi registrado, para alterar os dados sobre esse produto use a opção EDITAR\n");
        } else {
            this.listProduto.add(p);
            System.out.println("PRODUTO ADICIONADO!\n");
        }
    }
    
    //Método responsável por adicionar um novo produto na lista recebendo o produto como parametro
    public void add(Produto p) { 
        if (findProdutoForYourId(p.getId()) != null) {
            System.out.println("ERRO - O ID desse produto já foi registrado, para alterar os dados sobre esse produto use a opção EDITAR\n");
        } else {
            this.listProduto.add(p);
            System.out.println("PRODUTO ADICIONADO!\n");
        }
    }
    
    //Método responsável por remover um produto da lista
    public void remove() {
        Scanner scan = new Scanner(System.in);
        System.out.println("------ REMOVENDO UM PRODUTO -----");
        String idRemovido = Util.pegarId(scan);
        Produto removido = findProdutoForYourId(idRemovido);
        
        if (removido != null) {
            this.listProduto.remove(removido);
            System.out.println("PRODUTO REMOVIDO!\n");
        } else {
            System.out.println("ERRO - Esse produto não está registrado na lista!\n");
        }
    }
    
    //Método responsável por retornar o valor gasto em todos os pedidos
    public double valorTotalListProdutos() {
        double valorTotal = 0.0;
        
        for (Produto p : this.listProduto) {
            valorTotal += p.getPreco();
        }
        
        return valorTotal;
    }
        
    
    
    //Método responsável por copiar uma lista de produtos para outra
    public void copy(ListProduto orig) {
        this.listProduto.clear();
        
        for (Produto p : orig.getListProduto()) {
            this.listProduto.add(p);
        } 
    }    
    
    //Método responsável por retornar o tamanho da lista
    public int getTam() {
        return this.listProduto.size();
    }
    
    //Método responsável por retornar indice dentro da lista
    public Produto getIndex(int index) {
        return this.listProduto.get(index);
    }
    
    
    
    
}
