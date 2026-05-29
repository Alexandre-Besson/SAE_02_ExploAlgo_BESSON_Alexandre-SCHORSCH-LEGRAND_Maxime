import java.util.List;

/**
 * Programme principal permettant de lancer l'algorithme de Dijkstra
 * sur un graphe pondéré.
 * <p>
 * Ce programme construit un graphe, applique l'algorithme depuis
 * un sommet source, puis affiche les résultats ainsi qu'un chemin
 * vers un sommet donné.
 */
public class MainDijkstra {

    /**
     * Lance l'exécution de l'algorithme de Dijkstra sur un graphe prédéfini.
     * <p>
     * Le graphe est construit en mémoire, puis l'algorithme est exécuté
     * à partir du sommet "A". Les résultats sont affichés dans la console,
     * ainsi que le chemin de "A" vers "C".
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {

        GrapheListe g = new GrapheListe();

        g.ajouterArc("A","B",12);
        g.ajouterArc("A","D",87);

        g.ajouterArc("B","E",11);

        g.ajouterArc("D","B",23);
        g.ajouterArc("D","C",10);

        g.ajouterArc("E","D",43);

        Dijkstra d = new Dijkstra();

        Valeurs resultat = d.resoudre(g,"A");

        System.out.println(resultat);

        List<String> chemin = resultat.calculerChemin("C");

        System.out.println("Chemin A -> C : " + chemin);
    }
}