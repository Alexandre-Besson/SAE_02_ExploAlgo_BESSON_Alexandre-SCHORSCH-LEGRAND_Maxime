import java.util.List;

public interface Graphe {

    List<String> getNoeuds();

    List<Arc> getAdjacents(String noeud);
}