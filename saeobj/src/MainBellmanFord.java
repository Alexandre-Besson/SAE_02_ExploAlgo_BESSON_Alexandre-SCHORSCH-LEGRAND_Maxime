import java.util.List;

/**
 * Classe principale permettant de tester l'algorithme de Bellman-Ford
 * sur un graphe pondéré représenté par une liste d'arcs.
 *
 * <p>Cette classe construit un graphe, exécute l'algorithme de Bellman-Ford
 * puis affiche le plus court chemin entre deux sommets.</p>
 */
public class MainBellmanFord {

    /**
     * Point d'entrée du programme.
     *
     * <p>Crée un graphe pondéré, applique l'algorithme de Bellman-Ford,
     * puis affiche le chemin le plus court entre un sommet de départ
     * et un sommet d'arrivée.</p>
     *
     * <p>Les paramètres de ligne de commande peuvent remplacer les valeurs
     * par défaut :
     * <ul>
     *   <li>args[0] : sommet de départ</li>
     *   <li>args[1] : sommet de destination</li>
     * </ul>
     * </p>
     *
     * @param args arguments de la ligne de commande (optionnels)
     */
    public static void main(String[] args) {

        // Création du graphe
        GrapheListe graphe = new GrapheListe();

        // Ajout des arcs pondérés
        graphe.ajouterArc("A", "B", 12.0);
        graphe.ajouterArc("A", "D", 87.0);
        graphe.ajouterArc("B", "E", 11.0);
        graphe.ajouterArc("C", "A", 19.0);
        graphe.ajouterArc("D", "B", 23.0);
        graphe.ajouterArc("D", "C", 10.0);
        graphe.ajouterArc("E", "D", 43.0);

        // Valeurs par défaut
        String depart = "A";
        String destination = "C";

        // Surcharge via arguments si fournis
        if (args.length == 2) {
            depart = args[0];
            destination = args[1];
        }

        // Exécution de l'algorithme de Bellman-Ford
        BellmanFord bf = new BellmanFord();
        Valeurs resultat = bf.resoudre(graphe, depart);

        // Calcul du chemin vers la destination
        List<String> chemin = resultat.calculerChemin(destination);

        // Affichage du résultat
        System.out.println("Chemin de " + depart + " a " + destination + " :");
        System.out.println(chemin);
    }
}