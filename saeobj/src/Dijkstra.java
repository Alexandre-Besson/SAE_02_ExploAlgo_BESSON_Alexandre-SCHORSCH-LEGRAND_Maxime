import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    public Valeurs resoudre(Graphe g, String depart) {

        Valeurs v = new Valeurs();


        List<String> Q = new ArrayList<>();


        for (String noeud : g.getNoeuds()) {

            v.setValeur(noeud, Double.MAX_VALUE);
            v.setParent(noeud, null);

            Q.add(noeud);
        }


        v.setValeur(depart, 0);


        while (!Q.isEmpty()) {


            String u = null;
            double min = Double.MAX_VALUE;

            for (String noeud : Q) {

                if (v.getValeur(noeud) < min) {
                    min = v.getValeur(noeud);
                    u = noeud;
                }
            }


            Q.remove(u);


            for (Arc arc : g.getAdjacents(u)) {

                String voisin = arc.getCible();


                if (Q.contains(voisin)) {

                    double nouvelleDistance = v.getValeur(u) + arc.getPoids();

                    if (nouvelleDistance < v.getValeur(voisin)) {

                        v.setValeur(voisin, nouvelleDistance);

                        v.setParent(voisin,u);
                    }
                }
            }
        }

        return v;
    }
}