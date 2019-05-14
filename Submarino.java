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
public class Submarino extends Barco {
    public Submarino(Ponto2D pt, char d) {
        pos = pt;
        dir = d; // c, d, b, e
        localizacao = new Ponto2D[2];
        atingido = new boolean[2];
        for (int i = 0; i < atingido.length; i++)
            atingido[i] = false;
        localizacao[0] = pt;
        switch (d) {
            case 'c':
                localizacao[1] = new Ponto2D(pt.posX, pt.posY+1);
                break;
            case 'd':
                localizacao[1] = new Ponto2D(pt.posX+1, pt.posY);
                break;
            case 'b':
                localizacao[1] = new Ponto2D(pt.posX, pt.posY-1);
                break;
            case 'e':
                localizacao[1] = new Ponto2D(pt.posX-1, pt.posY);
                break;
            default:
                System.out.println("Direção invalida");
        }
    }
    
    @Override
    public String toString() {
        String res = "Submarino: ";
        for (int i = 0; i < atingido.length; i++) {
            res += "1: " + localizacao[i];
            if (atingido[i])
                res += " atingido;";
            else
                res += " não atingido";
        }
        return res;
    }
    // para testar um submarino
    public static void main(String[] args) {
        Submarino s = new Submarino(new Ponto2D(0, 0), 'c');
        System.out.println("Status do submarino:");
        System.out.println(s);
        s.recebeTiro(new Ponto2D(0, 0));
        System.out.println("Status do submarino:");
        System.out.print(s);
        if (s.afundou()) System.out.println(" O submarino afundou.");
        else System.out.println(" O submarino ainda não afundou.");
        s.recebeTiro(new Ponto2D(0, 1));
        System.out.println("Status do submarino:");
        System.out.print(s);
        if (s.afundou()) System.out.println(" O submarino afundou.");
        else System.out.println(" O submarino ainda não afundou.");
    }
}
