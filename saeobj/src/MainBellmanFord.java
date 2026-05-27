import java.util.List;

public class MainBellmanFord {
    public static void main(String[] args) {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 12.0);
        graphe.ajouterArc("A", "D", 87.0);
        graphe.ajouterArc("B", "E", 11.0);
        graphe.ajouterArc("C", "A", 19.0);
        graphe.ajouterArc("D", "B", 23.0);
        graphe.ajouterArc("D", "C", 10.0);
        graphe.ajouterArc("E", "D", 43.0);

        String depart = "A";
        String destination = "C";

        if (args.length == 2) {
            depart = args[0];
            destination = args[1];
        }

        BellmanFord bf = new BellmanFord();
        Valeurs resultat = bf.resoudre(graphe, depart);
        List<String> chemin = resultat.calculerChemin(destination);

        System.out.println("Chemin de " + depart + " a " + destination + " :");
        System.out.println(chemin);
    }
}