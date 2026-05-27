import java.util.ArrayList;
import java.util.List;

public class Arcs {
    private List<Arc> liste;

    public Arcs() {
        this.liste = new ArrayList<>();
    }

    public void ajouterArc(Arc a) {
        liste.add(a);
    }

    public List<Arc> getListe() {
        return liste;
    }

    public boolean estVide() {
        return liste.isEmpty();
    }


    public String toString() {
        return liste.toString();
    }
}