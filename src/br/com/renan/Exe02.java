package br.com.renan;

import java.util.Scanner;

public class Exe02 {

    public static void main(String[] args) {
        String funcao;
        funcao = recebeFuncao();
        int numero = posfixa(funcao);
        System.out.println("Resultado: " + numero);

    }

    //recebe a funcao que sera transformada em posfixa
    public static String recebeFuncao() {
        System.out.println("=== FUNÇÃO POSFIXA ===\n");
        Scanner console = new Scanner(System.in);
        String funcao = null;
        boolean validar = false;
        while (validar == false) {
            System.out.print("Digite uma função: ");
            funcao = console.nextLine();
            if (funcao.charAt(funcao.length() - 1) != '+' && funcao.charAt(funcao.length() - 1) != '*') {
                System.err.println("** Função inválida! **");
            } else {
                validar = true;
            }
        }
        return funcao;
    }

    //transforma a funcao de infixa para posfixa
    public static int posfixa(String funcao) {
        Pilha p = new Pilha();
        char caracter;
        String numGrande = "";
        int numeroPopado = 0;
        int valorPushado;

        for (int i = 0; i < funcao.length(); i++) {
            caracter = funcao.charAt(i);
            if ((caracter != ' ') && (caracter != '+') && (caracter != '*')) {
                if (i < funcao.length()) {
                    if (funcao.charAt(i + 1) == ' ') {
                        if (numGrande.equals("")) {
                            valorPushado = Integer.parseInt(String.valueOf(caracter));
                            p.push(valorPushado);
                        } else {
                            valorPushado = Integer.parseInt(numGrande);
                            p.push(valorPushado);
                            numGrande = "";
                        }
                    } else if (funcao.charAt(i + 1) != ' ' && funcao.charAt(i + 1) != '+'
                            && funcao.charAt(i + 1) != '*') {
                        if (numGrande.equals("")) {
                            numGrande += caracter;
                        }
                        numGrande += funcao.charAt(i + 1);
                    }
                }
            } else if (caracter == '+') {
                numeroPopado = (int) p.pop() + (int) p.pop();
                p.push(numeroPopado);
            } else if (caracter == '*') {
                numeroPopado = (int) p.pop() * (int) p.pop();
                p.push(numeroPopado);
            }
        }
        return numeroPopado;
    }
}
