import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestDIjkstra {
    public static void main(String[] args) {
        testPlusCourtChemin();
    }

    public static void testPlusCourtChemin() {

        GrapheListe g = new GrapheListe();

        g.ajouterNoeud("A");
        g.ajouterNoeud("B");
        g.ajouterNoeud("C");
        g.ajouterNoeud("D");
        g.ajouterNoeud("E");

        g.ajouterArc("A","B",12);
        g.ajouterArc("A","D",87);
        g.ajouterArc("B","E",11);
        g.ajouterArc("E","D",43);
        g.ajouterArc("D","C",10);
        g.ajouterArc("D","B",23);
        g.ajouterArc("C","A",19);

        Dijkstra d = new Dijkstra();

        Valeurs v = d.resoudre(g,"A");

        List<String> chemin = v.calculerChemin("C");

        assertEquals(76.0,v.getValeur("C"),0.001);

        assertEquals("[A, B, E, D, C]", chemin.toString()
        );
    }
}