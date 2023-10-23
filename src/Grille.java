import java.util.Random;

public class Grille {
    private final int size = 300;
    private final static int nb_individus = 20000;

    private int [] permu;

    private Individu [] individus;
    private int [][] grille_malades;

    public Grille() {
        this.permu = new int[nb_individus];
        this.grille_malades = new int[size][size];
        this.individus = new Individu[nb_individus];
        
        for (int i = 0  ; i < nb_individus - 20 ; i ++)
            individus[i] = new Individu(Etat.S, size);

        for (int i = nb_individus - 20  ; i < nb_individus ; i ++)
            individus[i] = new Individu(Etat.I, size);

        for (int i = 0; i < nb_individus; i++) {
            permu[i] = i;
        }
    }


    public int getNb_individus() {
        return nb_individus;
    }

    public Individu[] getIndividus() {
        return individus;
    }

    public int getSize() {
        return size;
    }

    public void deplacer_maj_individus()
    {
        generateRandomPermutation();

        for ( int i = 0 ; i < nb_individus ; i++)
        {
            int indiv = permu[i];
            individus[indiv].maj_individu(infection_voisinage(individus[indiv].getPosX(),individus[indiv].getPosY()));
            individus[indiv].deplacer_individu(size);
        }
    }

    private int infection_voisinage(int x, int y){
        int result = 0;
        for (int i = -1 ; i <= 1 ; i++){
            for (int j = -1 ; j <= 1 ; j++){
                result += grille_malades[(x+i + size) % size][(y+i + size) % size];

            }
        }
        return result;
    }

    public int[][] getGrille_malades() {
        return grille_malades;
    }

    public void razGrille_malade()
    {
        for (int i = 0 ; i < size ; i++)
        {
            for (int j = 0 ; j < size ;j++)
            {
                grille_malades[i][j] = 0;
            }
        }
    }

    public void generateRandomPermutation() {

        for (int i = nb_individus - 1; i > 0; i--) {
            int j = Individu.get_next_int_random_for_test(i+1);
            // Échanger permutation[i] et permutation[j]
            int temp = permu[i];
            permu[i] = permu[j];
            permu[j] = temp;
        }
    }
}
