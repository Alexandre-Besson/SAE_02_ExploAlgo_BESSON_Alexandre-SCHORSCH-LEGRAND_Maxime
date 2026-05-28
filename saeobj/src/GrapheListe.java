import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d'un graphe orienté pondéré basé sur des listes.
 *
 * <p>Le graphe est représenté par :
 * <ul>
 *   <li>une liste de sommets (noeuds)</li>
 *   <li>une liste d'adjacence contenant les arcs sortants de chaque sommet</li>
 * </ul>
 * </p>
 *
 * <p>Chaque sommet possède une liste d'arcs sortants stockée dans un objet {@link Arcs}.</p>
 */
public class GrapheListe implements Graphe {

    /** Liste des sommets du graphe */
    private List<String> noeuds;

    /** Liste d'adjacence associée à chaque sommet */
    private List<Arcs> adjacence;

    /**
     * Constructeur du graphe.
     *
     * <p>Initialise les structures de données vides.</p>
     */
    public GrapheListe() {
        this.noeuds = new ArrayList<>();
        this.adjacence = new ArrayList<>();
    }

    /**
     * Ajoute un sommet au graphe s'il n'existe pas déjà.
     *
     * @param nom nom du sommet à ajouter
     */
    public void ajouterNoeud(String nom) {
        if (!noeuds.contains(nom)) {
            noeuds.add(nom);
            adjacence.add(new Arcs());
        }
    }

    /**
     * Ajoute un arc orienté pondéré dans le graphe.
     *
     * <p>Si les sommets source ou cible n'existent pas,
     * ils sont automatiquement ajoutés.</p>
     *
     * @param source sommet de départ
     * @param cible sommet d'arrivée
     * @param poids coût de l'arc
     */
    public void ajouterArc(String source, String cible, double poids) {
        ajouterNoeud(source);
        ajouterNoeud(cible);

        int indexSource = noeuds.indexOf(source);
        adjacence.get(indexSource).ajouterArc(new Arc(cible, poids));
    }

    /**
     * Retourne la liste des sommets du graphe.
     *
     * @return liste des noms des sommets
     */
    public List<String> getNoeuds() {
        return noeuds;
    }

    /**
     * Retourne les arcs sortants d'un sommet.
     *
     * @param noeud sommet dont on veut les voisins
     * @return liste des arcs sortants (liste vide si sommet inexistant)
     */
    public List<Arc> getAdjacents(String noeud) {
        int index = noeuds.indexOf(noeud);

        if (index == -1) {
            return new ArrayList<>();
        }

        return adjacence.get(index).getListe();
    }

    /**
     * Affiche le graphe sous forme textuelle.
     *
     * <p>Chaque ligne représente un sommet et ses arcs sortants.</p>
     */
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