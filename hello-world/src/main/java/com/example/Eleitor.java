package com.example;

public class Eleitor {
    private String nome;
    private int idade;
    
    public Eleitor(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
}
