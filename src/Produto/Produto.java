package Produto;

import java.util.Scanner;

public class Produto {
    private int codigo;
    private String nome;
    private String tamanho;
    private String cor;
    private double valor;
    private int quantidade;

    public Produto(int codigo, String nome, String tamanho, String cor, double valor, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.tamanho = tamanho;
        this.cor = cor;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public void vender(int qtd, String metodoPagamento) {
        if (qtd > quantidade) {
            System.out.println("Estoque insuficiente!");
            return;
        }
        double total = valor * qtd;
        if (metodoPagamento.equalsIgnoreCase("Pix") || metodoPagamento.equalsIgnoreCase("Espécie") ||
                metodoPagamento.equalsIgnoreCase("Transferência") || metodoPagamento.equalsIgnoreCase("Débito")) {
            total *= 0.95;
        } else if (metodoPagamento.equalsIgnoreCase("Crédito")) {
            System.out.println("Compra parcelada em 3x de R$" + (total / 3));
        }
        System.out.println("Total a pagar: R$" + total);
        if (metodoPagamento.equalsIgnoreCase("Espécie")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Informe o valor entregue: R$");
            double pago = scanner.nextDouble();
            if (pago >= total) {
                System.out.println("Troco: R$" + (pago - total));
            } else {
                System.out.println("Valor insuficiente para a compra!");
                return;
            }
        }
        quantidade -= qtd;
        System.out.println("Venda realizada com sucesso! Estoque atualizado: " + quantidade);
    }
}