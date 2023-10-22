import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //s.test_individu_random();
        for (int i = 0; i < 100; i++) {
            Simulation s = new Simulation(730);
            s.simuler("simulation_result/test"+i+".txt");
        }
    }
}