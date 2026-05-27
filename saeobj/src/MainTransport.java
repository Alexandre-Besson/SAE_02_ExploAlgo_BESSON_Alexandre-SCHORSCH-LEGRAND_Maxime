public class MainTransport {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.err.println("Erreur : fournir depart et arrivee (codes STAN)");
            return;
        }

        String depart = args[0];
        String arrivee = args[1];

        try {
            // Chargement du graphe
            Graphe g = LireReseau.lire("stan.nodes.txt", "stan.edges.txt");

            // =========================
            // BELLMAN-FORD
            // =========================
            long startBF = System.nanoTime();
            BellmanFord bf = new BellmanFord();
            Valeurs resBF = bf.resoudre(g, depart);
            long endBF = System.nanoTime();

            // =========================
            // DIJKSTRA
            // =========================
            long startDJ = System.nanoTime();
            Dijkstra dj = new Dijkstra();
            Valeurs resDJ = dj.resoudre(g, depart);
            long endDJ = System.nanoTime();

            // =========================
            // CHEMINS
            // =========================
            String cheminBF = String.join(";", resBF.calculerChemin(arrivee));
            String cheminDJ = String.join(";", resDJ.calculerChemin(arrivee));

            // =========================
            // SORTIE POUR GUI (OBLIGATOIRE)
            // =========================
            System.out.println(cheminBF);

            // =========================
            // TEMPS (pour rapport / debug)
            // =========================
            System.err.println("Temps Bellman-Ford : " + (endBF - startBF) + " ns");
            System.err.println("Temps Dijkstra : " + (endDJ - startDJ) + " ns");

        } catch (Exception e) {
            System.err.println("Erreur exécution : " + e.getMessage());
            e.printStackTrace();
        }
    }
}