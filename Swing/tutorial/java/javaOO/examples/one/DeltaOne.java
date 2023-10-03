package one;

public class DeltaOne {
    public static void main(String[] args) {
        Alpha a = new Alpha();
      //a.privateMethod();    //illegal
        a.packageMethod();    //legal
        a.protectedMethod();  //legal
        a.publicMethod();     //legal

      //System.out.format("privateVariable:  %2d%n",
      //    a.privateVariable);    //illegal
        System.out.format("packageVariable:  %2d%n",
            a.packageVariable);    //legal
        System.out.format("protectedVariable: %2d%n",
            a.protectedVariable); //legal
        System.out.format("publicVariable: %2d%n",
            a.publicVariable);    //legal
    }
}
