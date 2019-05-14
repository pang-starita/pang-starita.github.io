/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhaNaval;

/**
 * Classe que representa as casas do tabuleiro.
 * Observe que uma casa tem um Ponto2D e não deriva de Ponto2D.
 * Porque uma casa não é um ponto. Ela memoriza que já foi atingida.
 * Ela poderia memorizar, também, qual barco a ocupa.
 * 
 * @author labb
 */
public class Casa {
    public Ponto2D pos;
    public boolean atingida;
    public boolean ocupada;
    public Casa(Ponto2D pt) {
        pos = pt;
        atingida = false;
        ocupada = false;
    }
    /**
     * Método usado para marcar que um tiro acertou esta casa, se ela já
     * tinha sido atingida, ela retorna false, se é a primeira vez ela retorna
     * true se a casa estava ocupada.
     * @return 
     */
    public boolean validaTiro() {
        if (atingida) return false;
        atingida = true;
        if (ocupada) return true;
        return false;
    }
    
    @Override
    public String toString() {
        if (! atingida) return "O";   // sem tiro
        if (! ocupada)  return "A";   // atingiu água
        return "X";                   // atingiu um barco
    }
    
}
