class Thread1 implements Runnable {
    Counter counter;
    String name;

    Thread1(Counter counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.incr();
            
        }
        System.out.println("Thread " + name + " finished.");
    }
}