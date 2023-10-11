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
}
