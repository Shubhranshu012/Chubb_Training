import java.util.*;

interface Greet {
    void sayHello();
}
public class lamdaFunction {
	Optional<String> prod(int x,int y) {
		return null;
	}
    public static void main(String[] args) {
    	
    	
        // Lambda expression
        Greet greet = () -> System.out.println("Hello from the lambda!");
        greet.sayHello(); 
        
        
        //Anonymous class
        Greet get = new Greet() {
        	@Override
            public void sayHello() {
                System.out.println("Hello from the anonymous class!");
            }
        };
        get.sayHello();
        lamdaFunction lf=new lamdaFunction();
        Optional<String> output=lf.prod(0, 0);
        
        System.out.println(Optional.ofNullable(lf.prod(0, 0)));
        
    }
}
