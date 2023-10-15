import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Simulation s = new Simulation(730);
        //s.test_individu_random();
        s.simuler("simulation_result/test6.txt");
    }
}