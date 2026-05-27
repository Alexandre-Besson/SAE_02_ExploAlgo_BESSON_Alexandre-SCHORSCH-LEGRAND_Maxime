import java.util.List;

public class MainDijkstra {

    public static void main(String[] args) {

        GrapheListe g = new GrapheListe();

        g.ajouterArc("A","B",12);
        g.ajouterArc("A","D",87);

        g.ajouterArc("B","E",11);

        g.ajouterArc("D","B",23);
        g.ajouterArc("D","C",10);

        g.ajouterArc("E","D",43);

        Dijkstra d = new Dijkstra();

        Valeurs resultat =
                d.resoudre(g,"A");

        System.out.println(resultat);

        List<String> chemin =
                resultat.calculerChemin("C");

        System.out.println(
                "Chemin A -> C : "
                        + chemin
        );
    }
}