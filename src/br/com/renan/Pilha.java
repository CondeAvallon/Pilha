
package br.com.renan;

public class Pilha {
    
    private Object[] dados;
    private int topo;
    
    public Pilha() {
        dados = new Object[50];
        topo = -1;
    }
    
    public boolean isFull() {
        return (topo == dados.length - 1);
    }
    
    public boolean isEmpty() {
        return (topo == -1);
    }
    
    public void push(Object x) {
        if (!isFull()) {
            topo++;
            dados[topo] = x;
        } else {
            System.out.println("Pilha cheia!");
        }
    }
    
    public Object pop() {
        if (!isEmpty()) {
            Object x  = dados[topo];
            topo--;
            return x;
        } else {
            System.out.println("Pilha vazia!");
            return null;
        }
    }
    
    public Object top() {
        if (!isEmpty()) {
            return dados[topo];
        } else {
            System.out.println("Pilha vazia!");
            return null;
        }
    }
    
}
