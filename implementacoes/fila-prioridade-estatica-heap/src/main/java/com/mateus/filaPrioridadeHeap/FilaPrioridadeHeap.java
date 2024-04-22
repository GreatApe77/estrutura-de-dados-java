package com.mateus.filaPrioridadeHeap;

public class FilaPrioridadeHeap<Chave,Valor> implements FilaPrioridade<Chave,Valor> {
    
    
     class ElementoDaFila implements Elemento<Chave,Valor> {
        Chave chave;
        Valor valor;
        
        @Override
        public Chave getChave() {
            return this.chave;
        }
        @Override
        public Valor getValor() {
            return this.valor;
        }

        @Override
        public String toString() {
            return "(" + chave + " - " + valor + ")";
        }
        
    }
    @Override
    public void insere(Chave chave, Valor valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insere'");
    }

    @Override
    public Elemento<Chave, Valor> frente() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frente'");
    }

    @Override
    public Elemento<Chave, Valor> remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int tamanho() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tamanho'");
    }

    @Override
    public boolean estaVazia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaVazia'");
    }
    
}
