package practice;



public class ThreadSleep implements Runnable {
    private String[] strings = {
            "A little bit like Paul",
            "He said with a bawl",
            "I want to crawl",
            "A little bit like Paul"
    };

    private Utils.Index index;

    public ThreadSleep(Utils.Index index) {
        this.index = index;
    }

    public static void main(String[] args) {
        Utils.Index index = new Utils.Index(0);
        (new Thread(new ThreadSleep(index))).start();
        (new Thread(new ThreadSleep(index))).start();
    }

    private void standardExample() throws InterruptedException {
        for (String s: strings) {
            System.out.println(s);
            Thread.sleep(2500);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                if (index.current() >= strings.length) {
                    Utils.threadMessage("All done");
                    return;
                }
                Utils.threadMessage(strings[index.current()]);
                index.increment();
            } catch (InterruptedException e) {
                Utils.threadMessage("Interrupted");
                return;
            }
        }
    }
}
