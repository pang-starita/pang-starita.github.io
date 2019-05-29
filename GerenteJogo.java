/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhaNaval;

import java.util.Scanner;

/**
 * Só existe um gerente do jogo, ele é quem conhece as regras do jogo e 
 * faz o jogador automático jogar com o usuário
 * @author labb
 */
public class GerenteJogo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // cria 2 tabuleiros, um para o jogadorBN e outro para o usuário
        Tabuleiro tabAuto = new Tabuleiro();
        Tabuleiro tabUser = new Tabuleiro();
        // cria os barcos para o jogador auto
        Barco[] bsAuto = new Barco[2];
        bsAuto[0] = new Destroyer();
        bsAuto[1] = new Submarino();
        // cria jogador auto
        JogadorBN jgAuto = new JogadorBN();
        // pede para o jogador auto posicionar os barcos
        jgAuto.posicionaBarcos(bsAuto, tabAuto);
        // cria os barcos do usuario
        Barco[] bsUser = new Barco[2];
        bsUser[0] = new Destroyer();
        bsUser[1] = new Submarino();
        // pede para usuário posicionar os barcos
        tabUser.tentaInserirBarco(bsUser[0], new Ponto2D(1, 1), 'd');
        tabUser.tentaInserirBarco(bsUser[1], new Ponto2D(5, 5), 'e');
        tabUser.barcos = bsUser;
        // tudo pronto para o jogo comecar
        while (!tabAuto.terminaJogo() && !tabUser.terminaJogo()) {
            // pede para o usuario dar os tiros e usa o recebeTiros()
            System.out.println("Fornessa a posicao dos 3 tiros:");
            if (sc.hasNext()) sc.next();    // para limpar excessos anteriores
            for (int i = 0; i < 3; i++) {
                System.out.print("Tiro " + (i+1) + ": ");
                int x = sc.nextInt();
                int y = sc.nextInt();
                tabAuto.recebeTiro(new Ponto2D(x, y));
                System.out.println("Tabuleiro apos o tiro: ");
                System.out.println(tabAuto);
            }
            // do tabAuto
            // se ja acabou break
            if (tabAuto.terminaJogo()) break;
            // se nao eh a vez o jogador auto
            Ponto2D[] tiros = jgAuto.atira(tabUser);
            for (Ponto2D tiro: tiros) {
                tabUser.recebeTiro(tiro);
                System.out.println("Seu tabuleiro apos tiro do jogador auto");
                System.out.println(tabUser);
            }
        }
        System.out.println("Terminou! Quem ganhou?");
        if (tabAuto.terminaJogo())
            System.out.println("O usuario ganhou");
        else
            System.out.println("O jogador automatico ganhou");
    }
}
