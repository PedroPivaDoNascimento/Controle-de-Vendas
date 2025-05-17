/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.ManipulacaoDosClientes;

import Classes.Utilitarios.Util;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author piva
 */
public class Cliente {
    private String nome;
    private String cpf;
    private int numPedidos;
    private double totalGasto;

    public Cliente() {
        this.nome = " ";
        this.cpf = " ";
        this.numPedidos = 0;
        this.totalGasto = 0.0;
    }
    public Cliente(String nome, String cpf, int numPedidos, double totalGasto) {
        this.nome = nome;
        this.cpf = cpf;
        this.numPedidos = numPedidos;
        this.totalGasto = totalGasto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getNumPedidos() {
        return numPedidos;
    }

    public void setNumPedidos(int numPedidos) {
        this.numPedidos = numPedidos;
    }

    public double getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(double totalGasto) {
        this.totalGasto = totalGasto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.cpf);
        hash = 37 * hash + this.numPedidos;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.totalGasto) ^ (Double.doubleToLongBits(this.totalGasto) >>> 32));
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
        final Cliente other = (Cliente) obj;
        if (this.numPedidos != other.numPedidos) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalGasto) != Double.doubleToLongBits(other.totalGasto)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.cpf, other.cpf);
    }
    
    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" + 
                "CPF: " + this.cpf + "\n" + 
                "Número de pedidos: " + this.numPedidos + "\n" + 
                "Total gasto: R$: " + this.totalGasto + "\n";
    }
    
    //Método responsável por pehar o CPF do cliente
    public static String pegarCpf(Scanner scan) {
        System.out.println("CPF: ");
        String cpf = scan.nextLine();
        return cpf;
    } 
    
    //Método responsável por preencher os dados do cliente
    public void fill() {
        Scanner scan = new Scanner(System.in);
        System.out.println("------ PREENCHENDO OS DADOS DO CLIENTE ------");
        this.nome = Util.pegarNome(scan);
        this.cpf = Cliente.pegarCpf(scan);
    }
    
    //Método responsável por imprimir os dados do cliente
    public void print() {
        System.out.println("------ DADOS DO CLIENTE -----");
        System.out.println(this.toString());
    }
    
    //Método responsável por copiar um cliente para outro
    public void copy(Cliente orig) {
        this.cpf = orig.getCpf();
        this.nome = orig.getNome();
    }
    
    
    
    
    
    
}
