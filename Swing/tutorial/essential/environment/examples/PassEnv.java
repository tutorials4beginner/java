import java.util.Map;

public class PassEnv {
    public static void main (String[] args) throws java.io.IOException {
        System.out.println(System.getProperty("java.class.path"));
        ProcessBuilder pb = new ProcessBuilder("java", "Env", "DRAGONBALLS");
        Map<String, String> env = pb.environment();
        env.put("DRAGONBALLS", "7");
        pb.start();
    }
}

