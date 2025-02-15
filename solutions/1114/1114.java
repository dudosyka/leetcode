class Foo {

    Semaphore second_, third_;

    public Foo() {
        second_ = new Semaphore(0);
        third_ = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second_.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second_.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third_.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third_.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}