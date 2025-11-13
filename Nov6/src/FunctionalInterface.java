import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.PriorityQueue;


public class FunctionalInterface {
    public static void main(String[] args) {
        var name=new ArrayList<String>();
        name.add("Alice");
        name.add("Bob");
        name.add("Charlie");
        
        var sr=name.stream().filter(a->a.startsWith("A")).collect(Collectors.toList());
        System.out.println(sr);

        AccountInfo account1 = new AccountInfo("123456789", 1000.50);
        AccountInfo account2 = new AccountInfo("123456780", 1000.50);
        AccountInfo account3=new AccountInfo("1234", 2000.50);

        List<AccountInfo> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);


        var temp=accounts.stream().sorted((a1,a2)->a1.accountNumber().compareTo(a2.accountNumber())).collect(Collectors.toList());
        List<Integer> numbers=new ArrayList<>();
        numbers.add(50);
        numbers.add(10);
        numbers.add(200);
        numbers.add(150);    
    
        var temp2=numbers.stream().sorted(new comp()).collect(Collectors.toList());
        PriorityQueue<Integer> pq=new PriorityQueue<>(new comp());

        var temp3=numbers.stream();
        temp3=temp3.filter(a->a>100);
        temp3=temp3.map(a-> a*100);
        temp3.forEach(a->System.out.println(a));

        System.out.println(temp);
        System.out.println(temp2);
        pq.add(100);
        pq.add(50);
        pq.add(200);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }



        String a="""
                This is a text block for example %s
                if you want to learn more about Science Reed Books:%d
                """.formatted("Hello", 10);

        System.out.println(a);

 var x1 = Arrays.asList("John", "Doe", "Jane", "Smith");
        var x2 = x1.stream().collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(x2);

        var x3=numbers.stream().collect(Collectors.toSet());
        System.out.println(x3);
    }
}
