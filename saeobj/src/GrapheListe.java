import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

    private List<String> noeuds;
    private List<Arcs> adjacence;

    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }


    public void ajouterNoeud(String nom) {
        if (!noeuds.contains(nom)) {
            noeuds.add(nom);
            adjacence.add(new Arcs());
        }
    }

    public void ajouterArc(String source, String cible, double poids) {
        ajouterNoeud(source);
        ajouterNoeud(cible);

        int indexSource = noeuds.indexOf(source);
        adjacence.get(indexSource).ajouterArc(new Arc(cible, poids));
    }


    public List<String> getNoeuds() {
        return noeuds;
    }


    public List<Arc> getAdjacents(String noeud) {
        int index = noeuds.indexOf(noeud);

        if (index == -1) {
            return new ArrayList<>();
        }

        return adjacence.get(index).getListe();
    }


    public void afficher() {
        for (int i = 0; i < noeuds.size(); i++) {
            System.out.print(noeuds.get(i) + " -> ");

            for (Arc a : adjacence.get(i).getListe()) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}