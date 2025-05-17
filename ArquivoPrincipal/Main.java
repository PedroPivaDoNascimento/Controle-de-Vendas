/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ArquivoPrincipal;

import Classes.ManipulacaoDosClientes.ListCliente;
import Classes.ManipulacaoDosProdutos.Estoque;
import Classes.ManipulcacaoDosPedidos.ListPedidos;
import java.util.Scanner;

/**
 *
 * @author piva
 */
public class Main {
    //Função responsável por mostrar as opções do painel dos pedidos
    static void menuPedidos() {
        System.out.println("----- PAINEL DOS PEDIDOS -----");
        System.out.println("1 - Adicionar nova pedido");
        System.out.println("2 - Remover pedido");
        System.out.println("3 - Mostrar total de pedidos");
        System.out.println("4 - Mostrar o faturamento total dos pedidos");
        System.out.println("5 - Sair");
    }
    //Função responsável por mostrar as opções do painel do estoque
    static void menuEstoque() {
        System.out.println("------ PAINEL DO ESTOQUE ------");
        System.out.println("1 - Adicionar um novo produto ao estoque");
        System.out.println("2 - Remover um produto já existente no estoque");
        System.out.println("3 - Produto que mais teve saída");
        System.out.println("4 - Produto que menos teve saída");
        System.out.println("5 - Sair");
    }
    //Função responsável por mostrar as opções do painel do cliente
    static void menuCliente() {
        System.out.println("----- PAINEL DOS CLIENTES -----");
        System.out.println("1 - Cadastrar um novo cliente");
        System.out.println("2 - Remover um cliente");
        System.out.println("3 - Clientes que fez mais pedidos");
        System.out.println("4 - Cliente que gastou mais dinheiro");
        System.out.println("5 - Sair");
    }
    //Função responsável por mostrar as opções do menu inicial
    static void menuInicial() {
        System.out.println("----- CONTROLE DE VENDAS -----");
        System.out.println("1 - Painel dos Clientes");
        System.out.println("2 - Painel do Estoque");
        System.out.println("3 - Painel dos pedidos");
        System.out.println("4 - Fechar o programa");
    }
    
    //Função responsável por pegar a opção de escolha do usuário no menu inicial
    static char pegaOpcaoMenuIncial(Scanner scan) {
        String opcao;
        
        do {
            menuInicial();
            System.out.println("Opção: ");
            opcao = scan.nextLine();
            
            if (opcao.length() != 0 || (opcao.charAt(0) != '1' && opcao.charAt(0) != '2' && opcao.charAt(0) != '3' && opcao.charAt(0) != '4')) {
                System.out.println("ERRO - A opção digitada não é válida!\n");
            } else {
                return opcao.charAt(0);
            }
            
        } while (true);
    }
    //Função responsável por pegar a opção de escolha do usuário no painel dos clientes
    static char pegarOpcaoMenuCliente(Scanner scan) {
        String opcao;
        
        do {
            menuCliente();
            System.out.println("Opção: ");
            opcao = scan.nextLine();
            
            if (opcao.length() != 0 || (opcao.charAt(0) != '1' && opcao.charAt(0) != '2' && opcao.charAt(0) != '3' && opcao.charAt(0) != '4') &&
                opcao.charAt(0) != '5' && opcao.charAt(0) != '6') {
                System.out.println("ERRO - A opção digitada não é válida!\n");
            } else {
                return opcao.charAt(0);
            }
            
        } while (true);
    }
    //Função responsável por pegar a opção da escolha do usuário no painel do estoque
    static char pegarOpcaoMenuEstoque(Scanner scan) {
        String opcao;
        
        do {
            menuEstoque();
            System.out.println("Opção: ");
            opcao = scan.nextLine();
            
            if (opcao.length() != 0 || (opcao.charAt(0) != '1' && opcao.charAt(0) != '2' && opcao.charAt(0) != '3' && opcao.charAt(0) != '4' &&
                opcao.charAt(0) != '5')) {
                System.out.println("ERRO - A opção digitada não é válida!\n");
            } else {
                return opcao.charAt(0);
            }
        } while (true);
    }
    //Função responsável por pegar a opção da escolha do usuário no painel dos pedidos
    static char pegarOpcaoMenuPedidos(Scanner scan) {
        String opcao;
        
        do {
            menuPedidos();
            System.out.println("Opção: ");
            opcao = scan.nextLine();
            
            if (opcao.length() != 0 || (opcao.charAt(0) != '1' && opcao.charAt(0) != '2' && opcao.charAt(0) != '3' && opcao.charAt(0) != '4' &&
                opcao.charAt(0) != '5')) {
                System.out.println("ERRO - A opção digitada não é válida!\n");
            } else {
                return opcao.charAt(0);
            }
        } while (true);
    }
    
    //Função responsável por executar a escolha feita no painel dos pedidos
    static void switchPainelPedidos(Scanner scan) {
        char opcao;
        
        do {
            opcao = pegarOpcaoMenuPedidos(scan);
            switch (opcao) {
                case '1':
                    ListPedidos.add();
                    break;
                case '2':
                    ListPedidos.remove();
                    break;
                case '3':
                    System.out.println(ListPedidos.getTam());
                    System.out.println("");
                    break;
                case '4':
                    System.out.println(ListPedidos.getFaturamentoTot());
                    System.out.println("");
                    break;
                case '5':
                    System.out.println("");
                default:
                    System.out.println("ERRO - Não foi possível pegar a opção inserida no menu!\n");
            } 
        } while (opcao != '5');
    }
    //Função responsável por executar a escolha feita no painel do estoque
    static void switchPainelEstoque(Scanner scan) {
        char opcao;
        
        do {
            opcao = pegarOpcaoMenuEstoque(scan);
            switch (opcao) {
                case '1' -> Estoque.add();
                case '2' -> Estoque.remove();
                case '3' -> Estoque.printProdutoQueTeveMaisSaida();
                case '4' -> Estoque.printProdutoQueTeveMenosSaida();
                case '5' -> System.out.println("");
                default -> System.out.println("ERRO - A opção digitada não é válida!\n");
            } 
        } while (opcao != '5');
    }
    //Função responsável por executar a escolha feita no painel do cliente
    static void switchPainelCliente(Scanner scan) {
        char opcao;
        
        do {
            opcao = pegarOpcaoMenuCliente(scan);
            switch (opcao) {
                case '1' -> ListCliente.add();
                case '2' -> ListCliente.remove();
                case '3' -> ListCliente.printClienteMaisPedidos();
                case '4' -> ListCliente.printClienteQueMaisGastou();
                case '5' -> System.out.println("");
                default -> System.out.println("ERRO - A opção do painel do cliente não foi reconhecida!\n");
            }
        } while (opcao != '5');
    }
    //Função main onde tem o switch com as funcionalidades do menu inicial
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char opcao;
        
        do{
            opcao = pegaOpcaoMenuIncial(scan);
            switch (opcao) {
                case '1' -> switchPainelCliente(scan);
                case '2' -> switchPainelEstoque(scan);
                case '3' -> switchPainelPedidos(scan);
                case '4' -> System.out.println("");
                default -> System.out.println("ERRO - Não foi possível pegar a opção inserida no menu!\n");

            }
        } while (opcao != '4');
        
        
    }
    
}
