package one;

public class Alpha {

    //member variables
    private   int privateVariable = 1;
              int packageVariable = 2;  //default access
    protected int protectedVariable = 3;
    public    int publicVariable = 4;

    //methods
    private void privateMethod() {
        System.out.format("privateMethod called%n");
    }
    void packageMethod() { //default access
        System.out.format("packageMethod called%n");
    }
    protected void protectedMethod() {
        System.out.format("protectedMethod called%n");
    }
    public void publicMethod() {
        System.out.format("publicMethod called%n");
    }

    public static void main(String[] args) {
        Alpha a = new Alpha();
        a.privateMethod();   //legal
        a.packageMethod();   //legal
        a.protectedMethod(); //legal
        a.publicMethod();    //legal

        System.out.format("privateVariable: %2d%n",
            a.privateVariable);    //legal
        System.out.format("packageVariable: %2d%n",
            a.packageVariable);    //legal
        System.out.format("protectedVariable: %2d%n",
            a.protectedVariable); //legal
        System.out.format("publicVariable: %2d%n",
            a.publicVariable);     //legal
    }
}
