public class Simulation {

    private Grille grille;
    private int nb_tour;

    public Simulation(int nb_tour) {
        this.nb_tour = nb_tour;
        this.grille = new Grille();
    }

    public void simuler(String nom_fichier)
    {
        int [] etat_pop = new int[4];
        maj_pop(etat_pop);

        for (int i = 0 ; i < nb_tour ; i++)
        {
            ecrire_fichier(i, etat_pop, nom_fichier);
        }






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


    private void ecrire_fichier(int tour, int [] etat_pop, String nom_fichier)
    {

    }
}
