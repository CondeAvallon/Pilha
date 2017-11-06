package br.com.renan;

import java.util.Scanner;

public class Exe02 {

    public static void main(String[] args) {
        String funcao;
        funcao = recebeFuncao();
        int numero = posfixa(funcao);
        System.out.println(numero);

    }

    public static String recebeFuncao() {
        Scanner console = new Scanner(System.in);
        String funcao;
        System.out.println("Digite uma função posfixa: ");
        funcao = console.nextLine();
        return funcao;
    }

    public static int posfixa(String funcao) {
        Pilha p = new Pilha();
        char c;
        String s;
        int numero = 0;
        for (int i = 0; i < funcao.length(); i++) {
            c = funcao.charAt(i);
            if ((c != ' ') && (c != '+') && (c != '*')) {
                if (i < funcao.length()) {
                    if (funcao.charAt(i + 1) == ' ') {
                        int a = Integer.parseInt(String.valueOf(c));
                        p.push(a);
                    }
                }
            } else if (c == '+') {
                numero = (int) p.pop() + (int) p.pop();
                p.push(numero);
            } else if (c == '*') {
                numero = (int) p.pop() * (int) p.pop();
                p.push(numero);
            } 
        }
        return numero;
    }
}