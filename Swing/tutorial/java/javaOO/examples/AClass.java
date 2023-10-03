import java.util.*;

public class AClass {

    public int instanceInteger = 0;
    public int instanceMethod() {
        return instanceInteger;
    }

    public static int classInteger = 0;
    public static int classMethod() {
        return classInteger;
    }

    public static void main(String[] args) {
        AClass anInstance = new AClass();
        AClass anotherInstance = new AClass();

        //Refer to instance members through an instance.
        anInstance.instanceInteger = 1;
        anotherInstance.instanceInteger = 2;
        System.out.format("%s%n", anInstance.instanceMethod());
        System.out.format("%s%n", anotherInstance.instanceMethod());

        //Illegal to refer directly to instance members from a class method
        //System.out.format("%s%n", instanceMethod());    //illegal
        //System.out.format("%s%n", instanceInteger);     //illegal

        //Refer to class members through the class...
        AClass.classInteger = 7;
        System.out.format("%s%n", classMethod());

        //...or through an instance.
        System.out.format("%s%n", anInstance.classMethod());

	//Instances share class variables
        anInstance.classInteger = 9;
        System.out.format("%s%n", anInstance.classMethod());
        System.out.format("%s%n", anotherInstance.classMethod());
    }
}
