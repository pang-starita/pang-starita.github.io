/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhaNaval;

import java.util.Scanner;

/**
 *
 * @author labb
 */
public class Tabuleiro {
    public final int tamanho = 10;  // tamanho do tabuleiro é de 10 x 10
    public Casa[][] tabu = new Casa[tamanho][tamanho];
    public Barco[] barcos;
    public Tabuleiro(Barco[] bs) {
        barcos = bs;
        for (int x = 0; x < tamanho; x++) {   // colocando as casas no tabuleiro
            for (int y = 0; y < tamanho; y++) {
                tabu[x][y] = new Casa(new Ponto2D(x, y));
            }
        }   // todas as casas foram inicializadas como desocupadas
        for (Barco bc: barcos) {  // para cada barco
            for (Ponto2D pos: bc.localizacao) {   // para cada ponto do barco
                tabu[pos.posX][pos.posY].ocupada = true;  // posição ocupada
            }
        }
    }
    
    public boolean recebeTiro(Ponto2D pt) {
        if (tabu[pt.posX][pt.posY].validaTiro()) { // acertou o tiro
            for (Barco ba: barcos) {      // para todos os barcos
                if (ba.recebeTiro(pt)) {  // acertou este barco
                    return true;
                }
            }
        }
        return false;  // agua
    }
    
    public boolean terminaJogo() {
        for (Barco bc: barcos) { // para cada barco
            if (! bc.afundou()) return false; // este nao afundou
        }
        return true;  // todos os barcos afundaram
    }
    
    @Override
    public String toString() {
        String res = "";
        for (int y=0; y < tamanho; y++) {     // linha
            for (int x=0; x < tamanho; x++) { // coluna
                res += " " + tabu[x][y] + " ";
            }
            res += "\n";
        }
        return res;
    }
    
    // para testar o tabuleiro
    public static void main(String[] args) {
        Barco[] barcos = new Barco[2];
        barcos[0] = new Destroyer(new Ponto2D(0, 0), 'd');
        barcos[1] = new Submarino(new Ponto2D(5, 5), 'e');
        Tabuleiro tab = new Tabuleiro(barcos);
        System.out.println("Tabuleiro atual:\n" + tab);
        tab.recebeTiro(new Ponto2D(0, 0));
        System.out.println("Novo tabuleiro:\n" + tab);
        tab.recebeTiro(new Ponto2D(1, 1));
        System.out.println("Novo tabuleiro:\n" + tab);
        Scanner sc = new Scanner(System.in);
        while (! tab.terminaJogo()) {   // pede ao usuario as posicoes dos tiros
            System.out.print("Fornessa a posicao do tiro, p.ex.: 5 5: ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if ((x < 0) || (x >= tab.tamanho) || (y < 0) || (y >= tab.tamanho)) {
                System.out.println("Coordenadas fora dos limites. Tente de novo.");
                break;
            }
            tab.recebeTiro(new Ponto2D(x, y));
            System.out.println("Tabuleiro depois do tiro: (" + x + ", " + y + ")\n" + tab);
        }
    }
}
