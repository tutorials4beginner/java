import java.util.*;
public class Cat extends Animal {

    public Cat() {
        super.setColor("white");
    }

    public static void hide() {
        System.out.format("The hide method in Cat.%n");
    }
    public void override() {
        System.out.format("The override method in Cat.%n");
    }

    // Returns a litter of cats
    public Collection<Cat> getLitter(int size) {
        ArrayList<Cat> litter = new ArrayList<Cat>(size);
            for (int i = 0; i < size; i++) 
                litter.add(i, new Cat());
            return litter;
        }
		
    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.hide();   
        myAnimal.override();
    }
}
