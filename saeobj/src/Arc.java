public class Arc {
    private String cible;
    private double poids;

    public Arc(String cible, double poids) {
        if (poids < 0) {
            throw new IllegalArgumentException("Le poids doit être positif");
        }
        this.cible = cible;
        this.poids = poids;
    }

    public String getCible() {
        return cible;
    }

    public double getPoids() {
        return poids;
    }


    public String toString() {
        return cible + "(" + poids + ")";
    }
}