/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Utilitarios;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author piva
 */
public class Util {
    //Método responsável por pegar o atributo nome dos objetos
    public static String pegarNome(Scanner scan) {
        System.out.println("Nome: ");
        String nome = scan.nextLine();
        return nome;
    }
    
    //Método responsável por pegar o atributo ID dos objetos
    public static String pegarId(Scanner scan) {
        System.out.println("ID: ");
        String id = scan.nextLine();
        return id;
    }
    
    public static int pegarQuantidade(Scanner scan) {
        while (true) {
            System.out.println("Quantidade: ");
            try {
                int quantidade = scan.nextInt();
                return quantidade;
            } catch (InputMismatchException e) {
                System.out.println("ERRO - Digite um número inteiro para a quantidade!\n");
            }
        }
    }
    
}
