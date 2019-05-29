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
public class Destroyer extends Barco {

    public Destroyer(Ponto2D pt, char d) {
        pos = pt;
        dir = d;
        localizacao = new Ponto2D[3];
        atingido = new boolean[3];
        for (int i = 0; i < atingido.length; i++)
            atingido[i] = false;
        localizacao[0] = pt;
        switch (d) {
            case 'c':
                localizacao[1] = new Ponto2D(pt.posX, pt.posY+1);
                localizacao[2] = new Ponto2D(pt.posX, pt.posY+2);
                break;
            case 'd':
                localizacao[1] = new Ponto2D(pt.posX+1, pt.posY);
                localizacao[2] = new Ponto2D(pt.posX+2, pt.posY);
                break;
            case 'b':
                localizacao[1] = new Ponto2D(pt.posX, pt.posY-1);
                localizacao[2] = new Ponto2D(pt.posX, pt.posY-2);
                break;
            case 'e':
                localizacao[1] = new Ponto2D(pt.posX-1, pt.posY);
                localizacao[2] = new Ponto2D(pt.posX-2, pt.posY);
                break;
            default:
                System.err.println("Direção inexistente");
                System.exit(1);
        }
    }
    
    public Destroyer() {    // posicao inicial desconhecida
        localizacao = new Ponto2D[3];
        atingido = new boolean[3];
        for (int i = 0; i < atingido.length; i++)
            atingido[i] = false;
    }
    
    @Override
    public boolean move(Ponto2D pt, char d, Tabuleiro tb) {
        // verifica se pode fazer o movimento proposto e posiciona
        if (tb.posOcupada(pt)) return false;
        // devia testar para cada posicao para verificar ser pode colocar o novo
        // barco nela ou não
        switch (d) {
            case 'c':
                if (pt.posY+2 >= tb.tamanho) return false;
                localizacao[0] = new Ponto2D(pt.posX, pt.posY);
                localizacao[1] = new Ponto2D(pt.posX, pt.posY+1);
                localizacao[2] = new Ponto2D(pt.posX, pt.posY+2);
                // marcar as posicoes como ocupadas
                tb.tabu[pt.posX][pt.posY].ocupada = true;
                tb.tabu[pt.posX][pt.posY+1].ocupada = true;
                tb.tabu[pt.posX][pt.posY+2].ocupada = true;
                break;
            case 'd':
                if (pt.posX+2 >= tb.tamanho) return false;
                localizacao[0] = new Ponto2D(pt.posX, pt.posY);
                localizacao[1] = new Ponto2D(pt.posX+1, pt.posY);
                localizacao[2] = new Ponto2D(pt.posX+2, pt.posY);
                tb.tabu[pt.posX][pt.posY].ocupada = true;
                tb.tabu[pt.posX+1][pt.posY].ocupada = true;
                tb.tabu[pt.posX+2][pt.posY].ocupada = true;
                break;
            case 'b':
                if (pt.posY-2 < 0) return false;
                localizacao[0] = new Ponto2D(pt.posX, pt.posY);
                localizacao[1] = new Ponto2D(pt.posX, pt.posY-1);
                localizacao[2] = new Ponto2D(pt.posX, pt.posY-2);
                tb.tabu[pt.posX][pt.posY].ocupada = true;
                tb.tabu[pt.posX][pt.posY-1].ocupada = true;
                tb.tabu[pt.posX][pt.posY-2].ocupada = true;
                break;
            case 'e':
                if (pt.posX-2 < 0) return false;
                localizacao[0] = new Ponto2D(pt.posX, pt.posY);
                localizacao[1] = new Ponto2D(pt.posX-1, pt.posY);
                localizacao[2] = new Ponto2D(pt.posX-2, pt.posY);
                tb.tabu[pt.posX][pt.posY].ocupada = true;
                tb.tabu[pt.posX-1][pt.posY].ocupada = true;
                tb.tabu[pt.posX-2][pt.posY].ocupada = true;
                break;
            default:
                System.err.println("Direção inexistente");
                System.exit(1);
        }
        pos = pt;
        dir = d;
        return true;
    }
    
    @Override
    public String toString() {
        String res = "Destroyer posicoes: ";
        for (int i = 0; i < atingido.length; i++) {
            res += "1: " + localizacao[i];
            if (atingido[i])
                res += " atingido;";
            else
                res += " não atingido";
        }
        return res;
    }
    // para testar um destroyer
    public static void main(String[] args) {
        Destroyer s = new Destroyer(new Ponto2D(1, 1), 'd');
        System.out.println("Status do destroyer:");
        System.out.println(s);
        Ponto2D p = new Ponto2D(0, 0);
        s.recebeTiro(p);
        System.out.println("Status do destroyer apos tiro em " + p + ":");
        System.out.print(s);
        if (s.afundou()) System.out.println(" O destroyer afundou.");
        else System.out.println(" O destroyer ainda não afundou.");
        p.posX = p.posX + 1;
        p.posY = p.posY + 1;
        s.recebeTiro(p);
        System.out.println("Status do destroyer apos tiro em " + p + ":");
        System.out.print(s);
        if (s.afundou()) System.out.println(" O destroyer afundou.");
        else System.out.println(" O destroyer ainda não afundou.");
        p.posX = p.posX + 1;
        s.recebeTiro(p);
        System.out.println("Status do destroyer apos tiro em " + p + ":");
        System.out.print(s);
        if (s.afundou()) System.out.println(" O destroyer afundou.");
        else System.out.println(" O destroyer ainda não afundou.");
        p.posX = p.posX + 1;
        s.recebeTiro(p);
        System.out.println("Status do destroyer apos tiro em " + p + ":");
        System.out.print(s);
        if (s.afundou()) System.out.println(" O destroyer afundou.");
        else System.out.println(" O destroyer ainda não afundou.");        
    }
}

