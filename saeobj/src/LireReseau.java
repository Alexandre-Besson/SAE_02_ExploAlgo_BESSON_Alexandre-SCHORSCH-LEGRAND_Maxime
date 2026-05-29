import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe utilitaire permettant de charger un graphe de transport
 * à partir de fichiers texte.
 * <p>
 * Le graphe est construit à partir :
 * <ul>
 *   <li>d'un fichier de stations (nœuds)</li>
 *   <li>d'un fichier de connexions pondérées (arêtes)</li>
 * </ul>
 */
public class LireReseau {

    /**
     * Lit deux fichiers et construit un graphe non orienté pondéré.
     *
     * @param fichier_stations fichier contenant la liste des stations (nœuds)
     * @param fichier_connexions fichier contenant les connexions entre stations (arêtes)
     * @return un graphe représentant le réseau de transport
     */
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