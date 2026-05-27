import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    public Valeurs resoudre(Graphe g, String depart) {

        Valeurs v = new Valeurs();

        // Liste des noeuds à traiter
        List<String> Q = new ArrayList<>();

        // Initialisation
        for (String noeud : g.getNoeuds()) {

            v.setValeur(noeud, Double.MAX_VALUE);
            v.setParent(noeud, null);

            Q.add(noeud);
        }

        // Le départ vaut 0
        v.setValeur(depart, 0);

        // Tant qu'il reste des noeuds à traiter
        while (!Q.isEmpty()) {

            // Recherche du noeud de valeur minimale
            String u = null;
            double min = Double.MAX_VALUE;

            for (String noeud : Q) {

                if (v.getValeur(noeud) < min) {
                    min = v.getValeur(noeud);
                    u = noeud;
                }
            }

            // Retirer le noeud traité
            Q.remove(u);

            // Parcourir ses voisins
            for (Arc arc : g.getAdjacents(u)) {

                String voisin = arc.getCible();

                // On ne traite que ceux encore dans Q
                if (Q.contains(voisin)) {

                    double nouvelleDistance =
                            v.getValeur(u) + arc.getPoids();

                    // Mise à jour si meilleur chemin
                    if (nouvelleDistance <
                            v.getValeur(voisin)) {

                        v.setValeur(
                                voisin,
                                nouvelleDistance
                        );

                        v.setParent(
                                voisin,
                                u
                        );
                    }
                }
            }
        }

        return v;
    }
}