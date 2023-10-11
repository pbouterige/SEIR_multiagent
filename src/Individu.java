import java.util.Random;

public class Individu {
    private double dE, dR, dI;
    private int timer = 0, posX, posY;
    private Etat etat;

    private static double lambdaE = 3.0;  // Paramètre pour dE
    private static double lambdaI = 7.0;  // Paramètre pour dR
    private static double lambdaR = 365.0;  // Paramètre pour dI

    private Random random = new Random();

    public Individu(Etat etat, int size) {
        this.etat = etat;

        dE = -lambdaE * Math.log(1 - random.nextDouble());
        dI = -lambdaI * Math.log(1 - random.nextDouble());
        dR = -lambdaR * Math.log(1 - random.nextDouble());


        posX = random.nextInt(size);
        posY = random.nextInt(size);

        System.out.println("dE : " + dE);
        System.out.println("dR : " + dR);
        System.out.println("dI : " + dI);

        System.out.println("posX : " + posX + " posY : " + posY);
    }

    public void deplacer_individu(int size)
    {
        this.timer ++;

        this.posX = random.nextInt(size);
        this.posY = random.nextInt(size);

    }

    public Etat getEtat() {
        return etat;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void maj_individu(int nb_malade_voisin)
    {
        switch (etat)
        {
            case S:
                double infectionProbability = 1 - Math.exp(-0.5 * nb_malade_voisin);
                double randomValue = Math.random();
                if (randomValue < infectionProbability)
                {
                    etat = Etat.E;
                    timer = 0;
                }
                break;
            case E:
                if (timer >= dE)
                {
                    etat = Etat.I;
                    timer = 0;
                }
                break;
            case I:
                if (timer >= dI)
                {
                    etat = Etat.R;
                    timer = 0;
                }
                break;
            case R:
                if (timer >= dR)
                {
                    etat = Etat.S;
                    timer = 0;
                }
                break;
        }
    }
}
