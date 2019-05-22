/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhaNaval;

/**
 *
 * @author labb
 */
public abstract class Barco {
    public Ponto2D pos;
    public char dir;
    public Ponto2D[] localizacao;
    public boolean[] atingido;
    public boolean recebeTiro(Ponto2D p) {
        for (int i = 0; i < localizacao.length; i++) {
            if (localizacao[i].equals(p)) { // se acertou
                atingido[i] = true;
                return true; // acertou
            }
        }
        return false;   // nenhum acerto, logo errou
    }
    public boolean afundou() {
        for (int i = 0; i < atingido.length; i++) {
            if (! atingido[i]) return false;    // esta posição não foi atingida
        }
        return true;    // todas as posições foram atingidas
    }
    // move o barco para uma dada posicao
    // returna falso se nao pode mover para esta posicao
    abstract public boolean move(Ponto2D pos, char d, Tabuleiro tb);
}
