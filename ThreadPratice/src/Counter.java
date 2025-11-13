class Counter {
    int a;

    Counter(int a) {
        this.a = a;
    }

     void incr() {
        
        for(int i=0;i<=5;i++) {
        	a++;
        	System.out.println(Thread.currentThread().getName() + " incremented to: " + a);
        }
        
    }

     void decre() {
        a--;
        System.out.println(Thread.currentThread().getName() + " decremented to: " + a);
    }
}