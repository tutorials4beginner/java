package two;
import one.*;

public class DeltaTwo {
    public static void main(String[] args) {
        Alpha a = new Alpha();
      //a.privateMethod();    //illegal
      //a.packageMethod();    //illegal
      //a.protectedMethod();  //illegal
        a.publicMethod();     //legal

      //System.out.format("privateVariable:   %2d%n",
      //  a.privateVariable);       //illegal
      //System.out.format("packageVariable:   %2d%n",
      //  a.packageVariable);       //illegal
      //System.out.format("protectedVariable: %2d%n",
      //  a.protectedVariable);   //illegal
        System.out.format("publicVariable:    %2d%n",
          a.publicVariable);         //legal
    }
}
