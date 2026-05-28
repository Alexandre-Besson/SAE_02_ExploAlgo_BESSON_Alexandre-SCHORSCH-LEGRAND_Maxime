import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant une collection d'arcs dans un graphe.
 *
 * <p>Cette classe encapsule une liste d'arcs orientés et pondérés,
 * permettant de manipuler facilement les relations entre sommets.</p>
 */
public class Arcs {

    /** Liste contenant l'ensemble des arcs */
    private List<Arc> liste;

    /**
     * Constructeur initialisant une liste vide d'arcs.
     */
    public Arcs() {
        this.liste = new ArrayList<>();
    }

    /**
     * Ajoute un arc à la collection.
     *
     * @param a l'arc à ajouter
     */
    public void ajouterArc(Arc a) {
        liste.add(a);
    }

    /**
     * Retourne la liste des arcs.
     *
     * @return liste des arcs
     */
    public List<Arc> getListe() {
        return liste;
    }

    /**
     * Vérifie si la collection d'arcs est vide.
     *
     * @return true si aucun arc n'est présent, false sinon
     */
    public boolean estVide() {
        return liste.isEmpty();
    }

    /**
     * Retourne une représentation textuelle de la collection d'arcs.
     *
     * @return chaîne contenant tous les arcs
     */
    @Override
    public String toString() {
        return liste.toString();
    }
}