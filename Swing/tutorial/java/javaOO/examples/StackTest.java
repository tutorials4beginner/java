import java.util.*;

public class StackTest {
    public static void main(String[] args) {
        Stack s = new Stack(3);
        s.push("hi");
        s.push("hello");
        s.push("good day");
        System.out.format("%s%n", s.pop());
        System.out.format("%s%n", s.pop());
        System.out.format("%s%n", s.pop());
    }
}
