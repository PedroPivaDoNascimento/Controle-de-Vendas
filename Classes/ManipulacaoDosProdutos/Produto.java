/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.ManipulacaoDosProdutos;

import Classes.Utilitarios.Util;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author piva
 */
public class Produto {
    private String nome;
    private String id;
    private double preco;
    private int vezesCompradas;

    public Produto() {
        this.nome = " ";
        this.id = " ";
        this.preco = 0.0;
        this.vezesCompradas = 0;
    }

    public Produto(String nome, String id, double preco, int vezesCompradas) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
        this.vezesCompradas = vezesCompradas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getVezesCompradas() {
        return vezesCompradas;
    }

    public void setVezesCompradas(int vezesCompradas) {
        this.vezesCompradas = vezesCompradas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = this.vezesCompradas + 79 * hash;
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
        final Produto other = (Produto) obj;
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.vezesCompradas == other.vezesCompradas) {
        } else {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
                "ID: " + this.id + "\n" + 
                "Preço: R$" + this.preco + "\n";
    }
   
    //Método responsável por pegar os valores dos dados do produto
    private static double pegarPreco(Scanner scan) {
        while (true) {
            System.out.println("Preço: R$");
            try {
                double preco = scan.nextDouble();
                return preco;
            } catch (InputMismatchException e) {
                System.out.println("ERRO - Digite um número real para o preço!\n");
            }
        }
    }
    
    //Método responsável por preencher os dados do produto para o estoque
    public void fillEstoque() {
        Scanner scan = new Scanner(System.in);
        System.out.println("------ PREENCHENDO OS DADOS DO PRODUTO ------");
        this.nome = Util.pegarNome(scan);
        this.id = Util.pegarId(scan);
        this.preco = Produto.pegarPreco(scan);
    }
    
    //Método responsável por imprimir os dados do produto
    public void print() {
        System.out.println("------ DADOS DO PRODUTO ------");
        System.out.println(this.toString());
    }
    
    //Método responsável por copiar um produto para outro
    public void copy(Produto orig) {
        this.id = orig.getId();
        this.nome = orig.getNome();
        this.preco = orig.getPreco();
        this.vezesCompradas = orig.getVezesCompradas();
    }
    
    
    
}
