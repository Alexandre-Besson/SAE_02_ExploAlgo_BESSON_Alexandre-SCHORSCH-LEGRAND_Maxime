public class MainTestBellmanFord {

    public static void main(String[] args) {
        testBellmanFordExemple();
        System.out.println("Tests de BellmanFord réussis !");
    }

    public static void testBellmanFordExemple() {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12.0);
        g.ajouterArc("A", "D", 87.0);
        g.ajouterArc("B", "E", 11.0);
        g.ajouterArc("C", "A", 19.0);
        g.ajouterArc("D", "B", 23.0);
        g.ajouterArc("D", "C", 10.0);
        g.ajouterArc("E", "D", 43.0);

        BellmanFord bf = new BellmanFord();
        Valeurs resultat = bf.resoudre(g, "A");

        if (resultat.getValeur("A") != 0.0) {
            throw new RuntimeException("Erreur : Distance de A à A doit être 0");
        }
        if (resultat.getValeur("B") != 12.0) {
            throw new RuntimeException("Erreur : Distance A -> B incorrecte");
        }
        if (resultat.getValeur("E") != 23.0) {
            throw new RuntimeException("Erreur : Distance A -> B -> E incorrecte");
        }
        if (resultat.getValeur("C") != 76.0) {
            throw new RuntimeException("Erreur : Distance A -> B -> E -> D -> C incorrecte");
        }

        if (!"D".equals(resultat.getParent("C"))) {
            throw new RuntimeException("Erreur : Le parent de C doit être D");
        }
        if (!"E".equals(resultat.getParent("D"))) {
            throw new RuntimeException("Erreur : Le parent de D doit être E");
        }
    }
}