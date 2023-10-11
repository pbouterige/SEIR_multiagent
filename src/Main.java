import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Simulation s = new Simulation(730);
        s.simuler("simulation_result/test.txt");
    }
}