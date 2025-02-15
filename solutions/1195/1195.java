class FizzBuzz {
    private int n;
    AtomicInteger cur;

    public FizzBuzz(int n) {
        this.n = n;
        cur = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        int local;
        while ((local = cur.get()) <= n) {
            if (local % 3 == 0 && local % 5 != 0) {
                printFizz.run();
                cur.compareAndSet(local, local + 1);
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int local;
        while ((local = cur.get()) <= n) {
            if (local % 3 != 0 && local % 5 == 0) {
                printBuzz.run();
                cur.compareAndSet(local, local + 1);
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int local;
        while ((local = cur.get()) <= n) {
            if (local % 3 == 0 && local % 5 == 0) {
                printFizzBuzz.run();
                cur.compareAndSet(local, local + 1);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        int local;
        while ((local = cur.get()) <= n) {
            if (local % 3 != 0 && local % 5 != 0) {
                printNumber.accept(local);
                cur.compareAndSet(local, local + 1);
            }
        }
    }
}