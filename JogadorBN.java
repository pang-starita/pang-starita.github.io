
package batalhaNaval;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class JogadorBN {
    Set<Ponto2D> tirosDados = new HashSet<Ponto2D>();
    // não precisa construtor
    /**
     * Posiciona os barcos
     * @param bs barcos
     * @param tb tabuleiro
     */
    public void posicionaBarcos(Barco[] bs, Tabuleiro tb) {
        int max = tb.tamanho;
        Random rd = new Random();
        // devia checar se o nao estah colocando numa posicao ocupada
        // nao vamos fazer este teste agora.
        // gerando uma posicao para cada barco no tabuleiro
        for (Barco b: bs) {
            Ponto2D pos = new Ponto2D(rd.nextInt(max), rd.nextInt(max));
            // a mensagem a seguir eh para testes, a linha deve ser retirada
            // na producao.
            System.out.println("posicionando barco em: " + pos);
            char[] direcoes = {'c','d','b','e'};
            char d = direcoes[rd.nextInt(direcoes.length)];
            while (! b.move(pos, d, tb)) {  // tenta outra posicao, nao muda dir
                pos.posX = rd.nextInt(max);
                pos.posY = rd.nextInt(max);
            }
        }
    }
    /**
     * Gera 3 tiros em posicoes novas
     * @param tb tabuleiro
     * @return posicoes dos 3 tiros
     */
    public Ponto2D[] atira(Tabuleiro tb) {
        Ponto2D[] tiros = new Ponto2D[3];
        Random rd = new Random();
        for (int i = 0; i < tiros.length; i++) {
            Ponto2D pos = new Ponto2D(rd.nextInt(tb.tamanho), rd.nextInt(tb.tamanho));
            while (tirosDados.contains(pos)) {
                pos.posX = rd.nextInt(tb.tamanho);
                pos.posY = rd.nextInt(tb.tamanho);
            }
            tiros[i] = pos;
            tirosDados.add(pos);
        }
        return tiros;
    }
}
