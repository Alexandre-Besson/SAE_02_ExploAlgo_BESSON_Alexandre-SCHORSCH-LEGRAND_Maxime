import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GrapheTest {

    public void testAjoutNoeudsEtArcs() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12.0);

        List<String> noeuds = g.getNoeuds();
        assertNotNull(noeuds);
        assertEquals(2, noeuds.size());
        assertTrue(noeuds.contains("A"));
        assertTrue(noeuds.contains("B"));

        List<Arc> adjA = g.getAdjacents("A");
        assertEquals(1, adjA.size());
        assertEquals("B", adjA.get(0).getCible());
        assertEquals(12.0, adjA.get(0).getPoids(), 0.001);
    }

    public void testAffichageFormat() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12.0);
        g.ajouterArc("A", "D", 87.0);

        String attendu = "A -> B(12) D(87)\nB -> \nD ->";
        assertEquals(attendu, g.toString());
    }

    public void testNoeudInexistant() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12.0);

        List<Arc> adjInexistant = g.getAdjacents("Z");
        assertNotNull(adjInexistant);
        assertTrue(adjInexistant.isEmpty());
    }
}