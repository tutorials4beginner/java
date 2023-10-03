import java.util.*;

public class Subclass extends Superclass {
    public boolean aVariable;       //hides aVariable in Superclass
    public void aMethod() {         //overrides aMethod in Superclass
        aVariable = false;
        super.aMethod();
        System.out.format("%b%n", aVariable);
        System.out.format("%b%n", super.aVariable);
    }
}
