
import java.util.HashSet;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Person p1 = new Person("Alice");
        Person p2 = new Person("Alice");
        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println(set.size()); 
    }
}
