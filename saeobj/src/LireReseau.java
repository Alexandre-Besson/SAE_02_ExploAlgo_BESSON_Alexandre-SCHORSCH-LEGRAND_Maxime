import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LireReseau {

    public static Graphe lire(String fichier_stations, String fichier_connexions) {
        GrapheListe graphe = new GrapheListe();

        try (BufferedReader brNodes = new BufferedReader(new FileReader(fichier_stations))) {
            String ligne;
            while ((ligne = brNodes.readLine()) != null) {
                String[] infos = ligne.split(";");
                if (infos.length >= 1) {
                    graphe.ajouterNoeud(infos[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader brEdges = new BufferedReader(new FileReader(fichier_connexions))) {
            String ligne;
            while ((ligne = brEdges.readLine()) != null) {
                String[] infos = ligne.split(";");
                if (infos.length >= 3) {
                    String depart = infos[0];
                    String arrivee = infos[1];
                    double distance = Double.parseDouble(infos[2]);

                    graphe.ajouterArc(depart, arrivee, distance);
                    graphe.ajouterArc(arrivee, depart, distance);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return graphe;
    }
}