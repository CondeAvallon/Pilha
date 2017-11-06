package br.com.renan;

import java.util.Scanner;

public class Exe01 {

    public static void main(String[] args) {
        String palavra, palavraInvertida;
        palavra = recebePalavra();
        palavraInvertida = inverterPalavra(palavra);
        System.out.println(palavraInvertida);
    }

    public static String recebePalavra() {
        Scanner console = new Scanner(System.in);
        String palavra;
        System.out.print("Digite uma palavra: ");
        palavra = console.next();
        return palavra;
    }

    public static String inverterPalavra(String palavra) {
        Pilha p = new Pilha();
        char letra = ' ';
        String palavraInvertida = "";
        for (int i = 0; i < palavra.length(); i++) {
            p.push(palavra.charAt(i));
        }
        while (!p.isEmpty()) {
            letra = (char) p.pop();
            palavraInvertida += letra;
        }
        return palavraInvertida;
    }

}
