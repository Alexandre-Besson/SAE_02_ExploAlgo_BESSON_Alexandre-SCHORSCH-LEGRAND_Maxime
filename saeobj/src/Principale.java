
/**
 * Programme principal de démonstration permettant de construire
 * un graphe pondéré et d'en afficher la structure.
 * <p>
 * Ce programme crée un graphe de type GrapheListe, ajoute des arcs
 * pondérés entre différents sommets, puis affiche le contenu du graphe.
 */
public class Principale {

    /**
     * Point d'entrée du programme.
     * <p>
     * Construit un graphe en mémoire avec des sommets et des arcs pondérés,
     * puis affiche sa représentation.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 12.0);
        graphe.ajouterArc("A", "D", 87.0);
        graphe.ajouterArc("B", "E", 11.0);
        graphe.ajouterArc("C", "A", 19.0);
        graphe.ajouterArc("D", "B", 23.0);
        graphe.ajouterArc("D", "C", 10.0);
        graphe.ajouterArc("E", "D", 43.0);

        graphe.afficher();
    }
}