import java.io.*;
import java.lang.reflect.Array;

public class Simulation {

    private Grille grille;
    private int nb_tour;
    private PrintWriter writer;

    public Simulation(int nb_tour) {
        this.nb_tour = nb_tour;
        this.grille = new Grille();
    }


    public void simuler(String nom_fichier) throws IOException {
        int[] etat_pop = new int[4];
        maj_pop(etat_pop);

        creerFichier(nom_fichier);

        for (int i = 0; i < nb_tour; i++) {
            ecrire_fichier(i, etat_pop, nom_fichier);

            grille.maj_individus();

            grille.deplacer_individus();

            maj_pop(etat_pop);

        }

    }

    public void test_individu_random()
    {
        int[] bins = new int[1000];
        for (int i = 0; i < bins.length; i++) {
            bins[i] = 0;
        }
        for (int i = 0; i < grille.getIndividus().length; i++) {
            bins[Individu.get_next_int_random_for_test(nb_tour)]++;
        }
        for (int i = bins.length - 1; i >= 0 ; i--) {
            System.out.println(bins[i]);
        }
    }

    private void maj_pop(int[] etat_pop) {
        for (int i = 0; i < 4; i++)
            etat_pop[i] = 0;

        grille.razGrille_malade();

        for (int i = 0; i < grille.getNb_individus(); i++) {
            Etat etat = grille.getIndividus()[i].getEtat();
            switch (etat) {
                case S:
                    etat_pop[0]++;
                    break;
                case E:
                    etat_pop[1]++;
                    break;
                case I:
                    etat_pop[2]++;
                    grille.getGrille_malades()
                    [grille.getIndividus()[i].getPosX()]
                    [grille.getIndividus()[i].getPosY()]++;
                    break;
                case R:
                    etat_pop[3]++;
                    break;
                default:
                    break;
            }
        }
    }

    public static void creerFichier(String nom_fichier) {
        try {
            File fichier = new File(nom_fichier);

            // Crée le fichier s'il n'existe pas
            if (!fichier.exists()) {
                fichier.createNewFile();
            }

            // Écriture des en-têtes dans le fichier
            BufferedWriter writer = new BufferedWriter(new FileWriter(fichier));
            writer.write("tour, S, E, I, R\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); // Gestion d'erreurs d'entrée/sortie
        }
    }

    public static void ecrire_fichier(int i, int[] etat_pop, String nom_fichier) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nom_fichier, true)); // Le paramètre true permet d'ajouter au fichier existant sans l'effacer.

            // Formatage de la ligne à écrire dans le fichier
            String ligne = String.format("%d, %d, %d, %d, %d%n", i, etat_pop[0], etat_pop[1], etat_pop[2], etat_pop[3]);

            // Écriture de la ligne dans le fichier
            writer.write(ligne);

            // Fermeture du fichier
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); // Gestion d'erreurs d'entrée/sortie
        }
    }


}