import java.util.List;

/**
 * Interface représentant un graphe.
 * <p>
 * Un graphe est défini par un ensemble de nœuds et des arcs reliant ces nœuds.
 * Cette interface permet d'accéder aux sommets et aux arcs adjacents.
 */
public interface Graphe {

    /**
     * Retourne la liste des nœuds présents dans le graphe.
     *
     * @return liste des identifiants des nœuds
     */
    List<String> getNoeuds();

    /**
     * Retourne la liste des arcs adjacents à un nœud donné.
     *
     * @param noeud le nœud dont on souhaite obtenir les voisins
     * @return liste des arcs sortants du nœud
     */
    List<Arc> getAdjacents(String noeud);
}