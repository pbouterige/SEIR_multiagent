public class Grille {
    private final int size = 300;
    private final int nb_individus = 20000;

    private Individu [] individus;
    private int [][] grille_malades;

    public Grille() {
        this.grille_malades = new int[size][size];
        this.individus = new Individu[nb_individus];
        for (int i = 0  ; i < nb_individus - 20 ; i ++)
            individus[i] = new Individu(Etat.S, size);
        for (int i = nb_individus - 20  ; i < nb_individus ; i ++)
            individus[i] = new Individu(Etat.I, size);
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

    public void maj_individus()
    {
        for ( int i = 0 ; i < nb_individus ; i++) { individus[i].maj_individu(infection_voisinage(individus[i].getPosX(),individus[i].getPosY()));}
    }

    public void deplacer_individus()
    {
        for ( int i = 0 ; i < nb_individus ; i++) { individus[i].deplacer_individu(size); }
    }

    private int infection_voisinage(int x, int y){
        int result = 0;
        for (int i = -1 ; i <= 1 ; i++){
            for (int j = -1 ; j <= 1 ; j++){
                    result += grille_malades[(x+i) % size][(y+i) % size];
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
}
