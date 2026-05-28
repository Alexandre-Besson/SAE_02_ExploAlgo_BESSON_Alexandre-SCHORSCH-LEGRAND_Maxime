 /**
 * Classe de test pour l'algorithme de Bellman-Ford.
 *
 * <p>Cette classe vérifie le bon fonctionnement de l'algorithme
 * sur un graphe d'exemple en comparant les distances calculées
 * et les parents attendus.</p>
 *
 * <p>Les tests sont effectués via des assertions manuelles
 * (exceptions levées en cas d'erreur).</p>
 */
public class MainTestBellmanFord {

    /**
     * Point d'entrée des tests.
     *
     * <p>Exécute un test principal de Bellman-Ford et affiche un message
     * si tous les tests sont réussis.</p>
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        testBellmanFordExemple();
        System.out.println("Tests de BellmanFord réussis !");
    }

    /**
     * Test principal de l'algorithme de Bellman-Ford sur un graphe donné.
     *
     * <p>Vérifie :
     * <ul>
     *   <li>les distances minimales depuis le sommet A</li>
     *   <li>la cohérence des chemins calculés</li>
     *   <li>les relations de parenté entre les sommets</li>
     * </ul>
     * </p>
     *
     * <p>Une exception est levée si une valeur attendue est incorrecte.</p>
     */
    public static void testBellmanFordExemple() {

        // Construction du graphe de test
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", 12.0);
        g.ajouterArc("A", "D", 87.0);
        g.ajouterArc("B", "E", 11.0);
        g.ajouterArc("C", "A", 19.0);
        g.ajouterArc("D", "B", 23.0);
        g.ajouterArc("D", "C", 10.0);
        g.ajouterArc("E", "D", 43.0);

        // Exécution de l'algorithme
        BellmanFord bf = new BellmanFord();
        Valeurs resultat = bf.resoudre(g, "A");

        // Vérification des distances
        if (resultat.getValeur("A") != 0.0) {
            throw new RuntimeException("Erreur : Distance de A à A doit être 0");
        }

        if (resultat.getValeur("B") != 12.0) {
            throw new RuntimeException("Erreur : Distance A -> B incorrecte");
        }

        if (resultat.getValeur("E") != 23.0) {
            throw new RuntimeException("Erreur : Distance A -> B -> E incorrecte");
        }

        if (resultat.getValeur("C") != 76.0) {
            throw new RuntimeException("Erreur : Distance A -> B -> E -> D -> C incorrecte");
        }

        // Vérification des parents (reconstruction du chemin)
        if (!"D".equals(resultat.getParent("C"))) {
            throw new RuntimeException("Erreur : Le parent de C doit être D");
        }

        if (!"E".equals(resultat.getParent("D"))) {
            throw new RuntimeException("Erreur : Le parent de D doit être E");
        }
    }
}