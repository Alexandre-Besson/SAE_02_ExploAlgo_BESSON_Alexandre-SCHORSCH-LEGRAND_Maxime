import java.util.List;

/**
 * Programme principal permettant de comparer deux algorithmes
 * de plus court chemin : Bellman-Ford et Dijkstra.
 * <p>
 * Le programme lit un réseau de transport à partir de fichiers,
 * puis calcule un chemin entre deux sommets fournis en arguments
 * de la ligne de commande.
 * <p>
 * Les temps d'exécution des deux algorithmes sont mesurés et affichés.
 */
public class MainTransport {

    /**
     * Point d'entrée du programme.
     * <p>
     * Attend deux arguments en ligne de commande :
     * le sommet de départ et le sommet d'arrivée.
     * <p>
     * Le programme :
     * <ul>
     *   <li>charge un graphe depuis des fichiers</li>
     *   <li>exécute Bellman-Ford et mesure son temps</li>
     *   <li>exécute Dijkstra et mesure son temps</li>
     *   <li>reconstruit les chemins trouvés</li>
     *   <li>affiche les résultats et les performances</li>
     * </ul>
     *
     * @param args arguments de la ligne de commande (depart, arrivee)
     */
    public static void main(String[] args) {

        try {

            if(args.length < 2){

                System.out.println("Usage : java MainTransport depart arrivee");

                return;
            }

            String depart=args[0];
            String arrivee=args[1];

            Graphe g =
                    LireReseau.lire("stan.nodes.txt", "stan.edges.txt");

            /*
             * Bellman Ford
             */

            BellmanFord bf = new BellmanFord();

            long debutBF = System.nanoTime();

            Valeurs valBF = bf.resoudre(g,depart);

            long finBF = System.nanoTime();

            List<String> cheminBF = valBF.calculerChemin(arrivee);

            /*
             * Dijkstra
             */

            Dijkstra d = new Dijkstra();

            long debutD = System.nanoTime();

            Valeurs valD = d.resoudre(g,depart);

            long finD = System.nanoTime();

            List<String> cheminD = valD.calculerChemin(arrivee);

            /*
             * affichage
             */

            System.out.println("Bellman Ford : "+ cheminBF);

            System.out.println("Temps BF : " +(finBF-debutBF) +" ns");

            System.out.println();

            System.out.println("Dijkstra : " + cheminD);

            System.out.println("Temps Dijkstra : " +(finD-debutD) +" ns");

        }
        catch(Exception e){

            e.printStackTrace();

        }
    }
}