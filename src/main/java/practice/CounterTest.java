package practice;

public class CounterTest implements Runnable {
    private Utils.Counter counter;

    CounterTest(Utils.Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        int x = counter.decrement();
        System.out.println("x = " + x);
    }

    public static void main(String[] args) {
        Utils.Counter counter = new Utils.Counter(10);
        for (int i = 0; i < 3; i++) {
            (new Thread(new CounterTest(counter))).start();
        }
    }
}
