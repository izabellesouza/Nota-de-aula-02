package Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastro de Produto");
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Tamanho/Peso: ");
        String tamanho = scanner.nextLine();
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        System.out.print("Valor: R$");
        double valor = scanner.nextDouble();
        System.out.print("Quantidade no estoque: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(codigo, nome, tamanho, cor, valor, quantidade);

        System.out.println("Produto cadastrado!");
        System.out.print("Deseja realizar uma venda? (S/N): ");
        scanner.nextLine();
        String opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("S")) {
            System.out.print("Quantidade a vender: ");
            int qtd = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Método de pagamento (Pix, Espécie, Transferência, Débito, Crédito): ");
            String metodo = scanner.nextLine();
            produto.vender(qtd, metodo);
        }

        scanner.close();
    }
}