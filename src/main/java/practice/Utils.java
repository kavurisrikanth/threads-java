package practice;

class Utils {
    static void threadMessage(String message) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " -> " + message);
    }

    static class Counter {
        private int count;

        Counter(int count) {
            this.count = count;
        }

        int increment() {
            this.count++;
            return this.count;
        }

        int decrement() {
            this.count--;
            return this.count;
        }
    }

    static class Index {
        private int index;

        Index(int index) {
            this.index = index;
        }

        int current() {
            return index;
        }

        void increment() {
            index++;
        }
    }
}
