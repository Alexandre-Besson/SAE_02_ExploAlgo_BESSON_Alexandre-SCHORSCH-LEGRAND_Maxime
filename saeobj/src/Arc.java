 /**
 * Classe représentant un arc orienté et pondéré dans un graphe.
 *
 * <p>Un arc relie un sommet source (implicite dans le graphe)
 * à un sommet cible avec un poids (coût de traversée).</p>
 */
public class Arc {

    /** Sommet cible de l'arc */
    private String cible;

    /** Poids associé à l'arc */
    private double poids;

    /**
     * Constructeur d'un arc.
     *
     * @param cible sommet cible de l'arc
     * @param poids poids de l'arc (doit être positif)
     * @throws IllegalArgumentException si le poids est négatif
     */
    public Arc(String cible, double poids) {
        if (poids < 0) {
            throw new IllegalArgumentException("Le poids doit être positif");
        }
        this.cible = cible;
        this.poids = poids;
    }

    /**
     * Retourne le sommet cible de l'arc.
     *
     * @return le nom du sommet cible
     */
    public String getCible() {
        return cible;
    }

    /**
     * Retourne le poids de l'arc.
     *
     * @return le poids de l'arc
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Retourne une représentation textuelle de l'arc.
     *
     * @return chaîne sous la forme "cible(poids)"
     */
    @Override
    public String toString() {
        return cible + "(" + poids + ")";
    }
}