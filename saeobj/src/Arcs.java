import java.util.ArrayList;
import java.util.List;

public class Arcs {
    List<Arc> Listedarc;
    public Arcs(){
        List<Arc> Listedarc= new ArrayList<Arc>();
    }
    public void addliste(Arc a){
        Listedarc.add(a);
    }
    public List<Arc> getListe(){
        return this.Listedarc;
    }
}
