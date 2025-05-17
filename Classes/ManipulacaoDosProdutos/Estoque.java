/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.ManipulacaoDosProdutos;

/**
 *
 * @author piva
 */
public class Estoque {
    private static final ListProduto estoque = new ListProduto();
    
    //Método responsável por adcionar um produto no estoque
    static public void add() {
        estoque.add();
    }
    //Método responsável por remover um produto do estoque
    static public void remove() {
        estoque.remove();
    }
   
    //Método responsável por retornar o produto dentro do estoque pelo seu id
    static public Produto findProdutoForYourId(String idProcurado) {
       return estoque.findProdutoForYourId(idProcurado);
    }
    
    //Método responsável por imprimir o produto que mais teve saída
    static public void printProdutoQueTeveMaisSaida() {
        int maiorSaida = 0;
        Produto produtoComMaiorSaida = new Produto();
        boolean swaped = false;
        
        for (int i = 0; i < Estoque.estoque.getTam(); i++) {
            if (maiorSaida < Estoque.estoque.getIndex(i).getVezesCompradas()) {
                maiorSaida = Estoque.estoque.getIndex(i).getVezesCompradas();
                produtoComMaiorSaida = Estoque.estoque.getIndex(i);
                swaped = true;
            }
        }
        
        if (swaped) {
            produtoComMaiorSaida.print();
        } else {
            System.out.println("ERRO - Nenhum produto deu saída!\n");
        }
    }
    
    //Método responsável por imprimir o produto que menos teve saída
    static public void printProdutoQueTeveMenosSaida() {
        int menorSaida = 99999;
        Produto produtoComMenorSaida = new Produto();
        boolean swaped = false;
        
        for (int i = 0; i < Estoque.estoque.getTam(); i++) {
            if (menorSaida > Estoque.estoque.getIndex(i).getVezesCompradas()) {
                menorSaida = Estoque.estoque.getIndex(i).getVezesCompradas();
                produtoComMenorSaida = Estoque.estoque.getIndex(i);
                swaped = true;
            }
        }
        
        if (swaped) {
            produtoComMenorSaida.print();
        } else {
            System.out.println("ERRO - Nenhum produto deu saída!\n");
        }
    }
}
