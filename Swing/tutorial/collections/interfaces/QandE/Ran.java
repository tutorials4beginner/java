import java.util.*;

public class Ran {
    public static void main(String[] args) {
        List<String> argList = Arrays.asList(args);
        Collections.shuffle(argList);
        for (String arg: argList) {
            System.out.format("%s ", arg);
        }
        System.out.println();
    }
}
