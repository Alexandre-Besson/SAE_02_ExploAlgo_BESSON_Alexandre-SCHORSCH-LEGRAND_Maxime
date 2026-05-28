import java.util.List;

/**
 * Implémentation de l'algorithme de Bellman-Ford.
 *
 * <p>Cet algorithme permet de calculer les plus courts chemins
 * depuis un sommet de départ vers tous les autres sommets d'un graphe
 * pondéré (poids positifs ou négatifs).</p>
 *
 * <p>Il met à jour progressivement les distances en relaxant
 * les arêtes jusqu'à stabilisation des valeurs.</p>
 */
public class BellmanFord {

    /**
     * Résout le problème des plus courts chemins depuis un sommet de départ.
     *
     * @param g le graphe pondéré
     * @param depart le sommet de départ
     * @return un objet {@link Valeurs} contenant les distances minimales
     *         et les parents permettant de reconstruire les chemins
     */
    public Valeurs resoudre(Graphe g, String depart) {

        // Structure contenant les distances et les parents
        Valeurs v = new Valeurs();

        // Liste de tous les sommets du graphe
        List<String> tousNoeuds = g.getNoeuds();

        // Initialisation : distances infinies + aucun parent
        for (String noeud : tousNoeuds) {
            v.setValeur(noeud, Double.MAX_VALUE);
            v.setParent(noeud, null);
        }

        // Distance du départ à lui-même = 0
        v.setValeur(depart, 0.0);

        boolean modification = true;

        // Boucle de relaxation des arêtes
        while (modification) {
            modification = false;

            for (String x : tousNoeuds) {

                double valeurX = v.getValeur(x);

                // Si le sommet est atteignable
                if (valeurX != Double.MAX_VALUE) {

                    for (Arc arc : g.getAdjacents(x)) {

                        String n = arc.getCible();
                        double poidsXN = arc.getPoids();
                        double nouvelleEstimation = valeurX + poidsXN;

                        // Relaxation de l'arête
                        if (nouvelleEstimation < v.getValeur(n)) {
                            v.setValeur(n, nouvelleEstimation);
                            v.setParent(n, x);
                            modification = true;
                        }
                    }
                }
            }
        }

        return v;
    }
}