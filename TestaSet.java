
package batalhaNaval;

import java.util.HashSet;
import java.util.Set;

public class TestaSet {
    public static void main(String[] args) {
        String[] textos = {"to que to", "qualquer coisa", "alguma coisa", "to que to"};
        for (String txt: textos) {
            System.out.println("Texto: " + txt);
        }
        if (textos[0] == textos[3])
            System.out.println("0 eh igual a 3");
        else
            System.out.println("O primeiro 'to que to' eh diferente do segundo");
        char[] tqt = {'t','o',' ','q','u','e',' ','t','o'};
        String tqt3 = new String(tqt);
        System.out.println("Terceiro to que to = " + tqt3);
        if (textos[0] == tqt3)
            System.out.println("0 eh igual a tqt3");
        else
            System.out.println("O primeiro 'to que to' eh diferente do terceiro");
        if (tqt3.equals(textos[0]))
            System.out.println("tqt3 tem o mesmo conteudo de textos[0].");
        else
            System.out.println("tqt3 tem conteudo diferente de textos[0].");
        Set<String> cjto = new HashSet<>();
        for (String txt: textos) {
            if (cjto.add(txt))
                System.out.println("Adicionou: " + txt);
            else
                System.out.println("Nao adicionou: " + txt);
        }
        System.out.print("Tentativa de adicionar tqt3: ");
        if (cjto.add(tqt3))
            System.out.println("Adicionou");    // mostra que usa ==
        else
            System.out.println("Não adicionou");// mostra que usa equals()
    }

}
