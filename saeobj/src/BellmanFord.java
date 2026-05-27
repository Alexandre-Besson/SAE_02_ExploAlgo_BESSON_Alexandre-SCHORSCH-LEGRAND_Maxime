import java.util.List;

public class BellmanFord {

    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs v = new Valeurs();
        List<String> tousNoeuds = g.getNoeuds();

        for (String noeud : tousNoeuds) {
            v.setValeur(noeud, Double.MAX_VALUE);
            v.setParent(noeud, null);
        }
        v.setValeur(depart, 0.0);

        boolean modification = true;
        while (modification) {
            modification = false;

            for (String x : tousNoeuds) {
                double valeurX = v.getValeur(x);

                if (valeurX != Double.MAX_VALUE) {
                    for (Arc arc : g.getAdjacents(x)) {
                        String n = arc.getCible();
                        double poidsXN = arc.getPoids();
                        double nouvelleEstimation = valeurX + poidsXN;

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