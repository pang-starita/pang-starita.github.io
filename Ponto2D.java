
package batnav;

/**
 *
 * @author Paulino Ng
 */
public class Ponto2D {
    public int posX, posY;
    public Ponto2D(int x, int y) {
        posX = x;
        posY = y;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) return false; // null eh o objeto vazio == ausencia de objeto
        if (! (o instanceof Ponto2D)) return false; // o nao eh Ponto2D
        Ponto2D p = (Ponto2D) o;
        return p.posX == posX && p.posY == posY; // eh igual se tem mesmas coord
    }
    
    @Override
    public String toString() {
        return "Ponto(" + posX + "," + posY + ")";
    }
    
    public static void main(String[] args) {
        Ponto2D p = new Ponto2D(2, 3);
        System.out.println("ponto 1: " + p);
        Ponto2D p2 = new Ponto2D(0, 0);
        if (p2.equals(p))
            System.out.println(p2 + " igual " + p);
        else
            System.out.println(p2 + " diferente de " + p);
        p2.posX = p.posX;
        p2.posY = p.posY;
        if (p2.equals(p))
            System.out.println(p2 + " igual " + p);
        else
            System.out.println(p2 + " diferente de " + p);
        if (p2 == p)
            System.out.println("p2 Ã© igual a p");
        else
            System.out.println("p2 Ã© diferente de p");
    }
}
