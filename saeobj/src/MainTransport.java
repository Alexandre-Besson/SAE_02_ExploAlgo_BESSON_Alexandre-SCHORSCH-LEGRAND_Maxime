package saeobj;

import java.util.List;

public class MainTransport {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Erreur : Deux identifiants de stations sont requis.");
            return;
        }

        String stationDepart = args[0];
        String stationArrivee = args[1];

        // Extraction du code entre crochets si Python envoie le format "Nom [CODE]"
        if (stationDepart.contains("[") && stationDepart.contains("]")) {
            stationDepart = stationDepart.substring(stationDepart.indexOf("[") + 1, stationDepart.indexOf("]"));
        }
        if (stationArrivee.contains("[") && stationArrivee.contains("]")) {
            stationArrivee = stationArrivee.substring(stationArrivee.indexOf("[") + 1, stationArrivee.indexOf("]"));
        }

        String fichierNodes = "stan.nodes.txt";
        String fichierEdges = "stan.edges.txt";

        Graphe graphe = LireReseau.lire(fichierNodes, fichierEdges);

        BellmanFord bf = new BellmanFord();

        long startTime = System.nanoTime();
        Valeurs resultat = bf.resoudre(graphe, stationDepart);
        long endTime = System.nanoTime();

        System.err.println("Temps execution Bellman-Ford : " + (endTime - startTime) + " ns");

        List<String> chemin = resultat.calculerChemin(stationArrivee);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chemin.size(); i++) {
            sb.append(chemin.get(i));
            if (i < chemin.size() - 1) {
                sb.append(";");
            }
        }

        System.out.println(sb.toString());
    }
}