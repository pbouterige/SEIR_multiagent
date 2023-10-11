import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Simulation {

    private Grille grille;
    private int nb_tour;
    private PrintWriter writer;

    public Simulation(int nb_tour) {
        this.nb_tour = nb_tour;
        this.grille = new Grille();
    }



    public void simuler(String nom_fichier)
    {
        int [] etat_pop = new int[4];
        maj_pop(etat_pop);


        init_writer(nom_fichier);
        for (int i = 0 ; i < nb_tour ; i++)
        {
            ecrire_fichier(i, etat_pop);
        }
        
        
        
        
        
        
        close_writer();
    }

    private void maj_pop(int [] etat_pop){
        for (int i = 0 ; i < 4 ; i++)
            etat_pop[i] = 0;

        for (int i = 0 ; i < grille.getNb_individus() ; i++)
        {
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
                    break;
                case R:
                    etat_pop[3]++;
                    break;
                default:
                    break;
            }
        }
    }

    private void init_writer(String nom_fichier)
    {
        try {
            writer = new PrintWriter(nom_fichier, "UTF-8");
            writer.println("T,S,E,I,R");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void close_writer()
    {
        writer.close();
    }

    private void ecrire_fichier(int tour, int [] etat_pop)
    {
        StringBuilder s = new StringBuilder(tour);
        for (int i = 0; i < etat_pop.length; i++) {
            s.append(etat_pop[i]);
        }
        writer.println(s);
        s = null;
    }
}
