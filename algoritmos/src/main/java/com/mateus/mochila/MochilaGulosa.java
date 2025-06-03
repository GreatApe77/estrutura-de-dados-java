package com.mateus.mochila;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MochilaGulosa {

    public static void main(String[] args) {
        Item[] itens = {
                new Item("Espada de Ferro", 10, 150),
                new Item("Poção de Vida", 1, 50),
                new Item("Armadura de Couro", 15, 200),
                new Item("Elmo de Aço", 8, 120),
                new Item("Anel Mágico", 1, 500),
                new Item("Botas de Agilidade", 5, 300),
                new Item("Cajado de Fogo", 12, 450),
                new Item("Escudo de Madeira", 9, 100),
                new Item("Livro de Feitiços", 6, 250),
                new Item("Colar de Proteção", 2, 350),
                new Item("Unha de urso", 1, 40),
                new Item("Dedo de gigante", 4, 220),
                new Item("Armadura De Dragao", 8, 850)
                
        };
        var resultado = problemaMochilha(11, Arrays.asList(itens));
        resultado.forEach(item -> System.out.println(item.getNome()));
    }

    public static List<Item> problemaMochilha(int capacidade, List<Item> itensDisponiveis) {
        List<Item> itensOrdenadosPorTaxa = new ArrayList<Item>(itensDisponiveis);
        itensOrdenadosPorTaxa.sort((o1, o2) -> Double.compare(o2.calcularTaxa(), o1.calcularTaxa()));
        List<Item> itensEscolhidos = new ArrayList<>();
        int somaPesos = 0;
        for (int i = 0; i < itensOrdenadosPorTaxa.size(); i++) {
            if (somaPesos + itensOrdenadosPorTaxa.get(i).getPeso() <= capacidade) {
                somaPesos += itensOrdenadosPorTaxa.get(i).getPeso();
                itensEscolhidos.add(itensOrdenadosPorTaxa.get(i));
            }
        }
        return itensEscolhidos;
    }
}

class Item {
    private String nome;
    private int peso;
    private double preco; // Desconsiderando os centavos por enquanto

    public Item(String nome, int peso, double preco) {
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    public double calcularTaxa() {
        return preco / peso;
    }

    public String getNome() {
        return nome;
    }

    public int getPeso() {
        return peso;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Item [nome=" + nome + ", peso=" + peso + ", preco=" + preco + ", calcularTaxa()=" + calcularTaxa()
                + "]";
    }
}