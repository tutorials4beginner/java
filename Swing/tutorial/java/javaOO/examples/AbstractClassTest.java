import java.util.*;

public class AbstractClassTest {
    public static void main(String[] args) {
        
        //check out the class alien one
        AlienCreatureOne aOne=new AlienCreatureOne();
        System.out.format("%s%n", aOne.lifeBegins());
        System.out.format("%s%n", aOne.live());
        System.out.format("%s%n", aOne.lifeEnds());
        
        //check out the class alien two
        AlienCreatureTwo aTwo=new AlienCreatureTwo();
        System.out.format("%s%n", aTwo.lifeBegins());
        System.out.format("%s%n", aTwo.live());
        System.out.format("%s%n", aTwo.lifeEnds());
    }
    
}
