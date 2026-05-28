import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Classe de tests unitaires pour la classe GrapheListe.
 *
 * <p>Ces tests vérifient :
 * <ul>
 *   <li>L'ajout correct des nœuds et des arcs</li>
 *   <li>Le format d'affichage du graphe</li>
 *   <li>Le comportement lors de la recherche d'un nœud inexistant</li>
 * </ul>
 * </p>
 */
public class GrapheTest {

    /**
     * Teste l'ajout de nœuds et d'arcs dans le graphe.
     *
     * <p>Vérifie que :
     * <ul>
     *   <li>Les nœuds sont correctement créés</li>
     *   <li>Les adjacences sont correctes</li>
     *   <li>Les poids et cibles des arcs sont cohérents</li>
     * </ul>
     * </p>
     */
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

    /**
     * Teste le format d'affichage du graphe.
     *
     * <p>Vérifie que la méthode toString() respecte le format attendu.</p>
     */

    public void testAffichageFormat() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12.0);
        g.ajouterArc("A", "D", 87.0);

        String attendu = "A -> B(12) D(87)\nB -> \nD ->";
        assertEquals(attendu, g.toString());
    }

    /**
     * Teste le comportement lorsque l'on demande les arcs d'un nœud inexistant.
     *
     * <p>Vérifie que la méthode retourne une liste vide et non null.</p>
     */

    public void testNoeudInexistant() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12.0);

        List<Arc> adjInexistant = g.getAdjacents("Z");
        assertNotNull(adjInexistant);
        assertTrue(adjInexistant.isEmpty());
    }
}