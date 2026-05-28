import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe représentant un ensemble de valeurs associées à des nœuds,
 * ainsi que leurs relations de parenté.
 *
 * <p>Chaque élément est identifié par un nom (String) et possède :
 * <ul>
 *   <li>une valeur numérique (double)</li>
 *   <li>un parent (String)</li>
 * </ul>
 * Cette structure peut être utilisée pour représenter un arbre ou un graphe orienté.</p>
 */
public class Valeurs {

    /** Map associant un nom de nœud à sa valeur numérique */
    Map<String, Double> valeur;

    /** Map associant un nœud à son parent */
    Map<String, String> parent;

    /**
     * Constructeur initialisant les structures de données.
     *
     * <p>Utilise des TreeMap afin de conserver les clés triées.</p>
     */
    public Valeurs() {
        this.valeur = new TreeMap<>();
        this.parent = new TreeMap<>();
    }

    /**
     * Définit la valeur associée à un nœud.
     *
     * @param nom nom du nœud
     * @param valeur valeur numérique associée
     */
    public void setValeur(String nom, double valeur) {
        this.valeur.put(nom, valeur);
    }

    /**
     * Définit le parent d'un nœud.
     *
     * @param nom nom du nœud
     * @param parent nom du parent
     */
    public void setParent(String nom, String parent) {
        this.parent.put(nom, parent);
    }

    /**
     * Retourne le parent d'un nœud.
     *
     * @param nom nom du nœud
     * @return le parent associé, ou null si inexistant
     */
    public String getParent(String nom) {
        return this.parent.get(nom);
    }

    /**
     * Retourne la valeur associée à un nœud.
     *
     * @param nom nom du nœud
     * @return la valeur associée
     */
    public double getValeur(String nom) {
        return this.valeur.get(nom);
    }

    /**
     * Retourne une représentation textuelle de l'ensemble des nœuds.
     *
     * @return chaîne contenant les nœuds avec leur valeur et leur parent
     */
    @Override
    public String toString() {
        String res = "";

        for (String s : this.valeur.keySet()) {
            Double valeurNoeud = valeur.get(s);
            String noeudParent = parent.get(s);
            res += s + " ->  V:" + valeurNoeud + " p:" + noeudParent + "\n";
        }
        return res;
    }

    /**
     * Calcule le chemin depuis un nœud jusqu'à la racine en suivant les parents.
     *
     * <p>Le chemin est construit en remontant les relations parentales.</p>
     *
     * @param destination nœud de départ
     * @return liste représentant le chemin du nœud jusqu'à la racine
     */
    public List<String> calculerChemin(String destination) {
        List<String> chemin = new ArrayList<>();
        String courant = destination;

        while (courant != null) {
            chemin.add(0, courant);
            courant = this.getParent(courant);
        }

        // sécurité : si incohérence, retourne liste vide
        if (chemin.isEmpty() || !chemin.get(0).equals(chemin.get(0))) {
            return new ArrayList<>();
        }

        return chemin;
    }
}