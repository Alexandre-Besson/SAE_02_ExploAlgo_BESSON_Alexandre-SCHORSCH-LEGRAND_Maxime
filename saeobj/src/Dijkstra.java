import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de l'algorithme de Dijkstra.
 *
 * <p>Cet algorithme permet de calculer les plus courts chemins
 * depuis un sommet de départ vers tous les autres sommets
 * d'un graphe pondéré à poids positifs.</p>
 *
 * <p>Il repose sur une sélection répétée du sommet ayant
 * la plus petite distance temporaire.</p>
 */
public class Dijkstra {

    /**
     * Résout le problème des plus courts chemins depuis un sommet de départ.
     *
     * @param g le graphe pondéré
     * @param depart le sommet de départ
     * @return un objet {@link Valeurs} contenant les distances minimales
     *         et les parents pour reconstruire les chemins
     */
    public Valeurs resoudre(Graphe g, String depart) {

        // Structure des distances et des parents
        Valeurs v = new Valeurs();

        // Ensemble des sommets non encore traités
        List<String> Q = new ArrayList<>();

        // Initialisation
        for (String noeud : g.getNoeuds()) {

            v.setValeur(noeud, Double.MAX_VALUE);
            v.setParent(noeud, null);

            Q.add(noeud);
        }

        // Distance de départ = 0
        v.setValeur(depart, 0);

        // Boucle principale
        while (!Q.isEmpty()) {

            // Sélection du sommet avec la plus petite distance
            String u = null;
            double min = Double.MAX_VALUE;

            for (String noeud : Q) {
                if (v.getValeur(noeud) < min) {
                    min = v.getValeur(noeud);
                    u = noeud;
                }
            }

            // Retirer le sommet traité
            Q.remove(u);

            // Relaxation des voisins
            for (Arc arc : g.getAdjacents(u)) {

                String voisin = arc.getCible();

                if (Q.contains(voisin)) {

                    double nouvelleDistance = v.getValeur(u) + arc.getPoids();

                    if (nouvelleDistance < v.getValeur(voisin)) {

                        v.setValeur(voisin, nouvelleDistance);
                        v.setParent(voisin, u);
                    }
                }
            }
        }

        return v;
    }
}