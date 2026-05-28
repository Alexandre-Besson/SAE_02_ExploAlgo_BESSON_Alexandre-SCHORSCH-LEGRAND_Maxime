import java.util.List;

public class MainTransport {

    public static void main(String[] args) {

        try {

            if(args.length < 2){

                System.out.println(
                        "Usage : java MainTransport depart arrivee"
                );

                return;
            }

            String depart=args[0];
            String arrivee=args[1];

            Graphe g =
                    LireReseau.lire(
                            "stan.nodes.txt",
                            "stan.edges.txt"
                    );

            /*
             * Bellman Ford
             */

            BellmanFord bf =
                    new BellmanFord();

            long debutBF =
                    System.nanoTime();

            Valeurs valBF =
                    bf.resoudre(g,depart);

            long finBF =
                    System.nanoTime();

            List<String> cheminBF =
                    valBF.calculerChemin(arrivee);

            /*
             * Dijkstra
             */

            Dijkstra d =
                    new Dijkstra();

            long debutD =
                    System.nanoTime();

            Valeurs valD =
                    d.resoudre(g,depart);

            long finD =
                    System.nanoTime();

            List<String> cheminD =
                    valD.calculerChemin(arrivee);

            /*
             * affichage
             */

            System.out.println(
                    "Bellman Ford : "
                            + cheminBF
            );

            System.out.println(
                    "Temps BF : "
                            +(finBF-debutBF)
                            +" ns"
            );

            System.out.println();

            System.out.println(
                    "Dijkstra : "
                            + cheminD
            );

            System.out.println(
                    "Temps Dijkstra : "
                            +(finD-debutD)
                            +" ns"
            );


        }
        catch(Exception e){

            e.printStackTrace();

        }

    }

}