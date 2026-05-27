import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheListe implements Graphe {

    private List<String> noeuds;
    private List<Arcs> adjacence;
    private Map<String, Integer> indexMap;

    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
        this.indexMap = new HashMap<>();
    }

    public void ajouterNoeud(String nom) {
        if (!indexMap.containsKey(nom)) {
            indexMap.put(nom, noeuds.size());
            noeuds.add(nom);
            adjacence.add(new Arcs());
        }
    }

    public void ajouterArc(String source, String cible, double poids) {
        ajouterNoeud(source);
        ajouterNoeud(cible);

        int index = indexMap.get(source);
        adjacence.get(index).ajouterArc(new Arc(cible, poids));
    }


    public List<String> getNoeuds() {
        return noeuds;
    }


    public List<Arc> getAdjacents(String noeud) {
        Integer index = indexMap.get(noeud);
        if (index == null) return new ArrayList<>();
        return adjacence.get(index).getListe();
    }

    public void afficher() {
        for (String n : noeuds) {
            System.out.print(n + " -> ");
            for (Arc a : getAdjacents(n)) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}