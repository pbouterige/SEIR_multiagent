import java.util.Random;

public class Individu {
    private double dE, dR, dI;
    private int timer = 0;
    private Etat etat;

    private double lambdaE = 3.0;  // Paramètre pour dE
    private double lambdaR = 7.0;  // Paramètre pour dR
    private double lambdaI = 365.0;  // Paramètre pour dI

    private Random random = new Random();

    public Individu(Etat etat) {
        this.etat = etat;

        dE = -Math.log(1 - random.nextDouble()) / lambdaE;
        dR = -Math.log(1 - random.nextDouble()) / lambdaR;
        dI = -Math.log(1 - random.nextDouble()) / lambdaI;

        System.out.println("dE : " + dE);
        System.out.println("dR : " + dR);
        System.out.println("dI : " + dI);
    }

    public void upTimer(){
        this.timer += 1;
    }

}
