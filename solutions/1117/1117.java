class H2O {
    CyclicBarrier barrier;
    Semaphore oSem, hSem;
    public H2O() {
        barrier = new CyclicBarrier(3);
        oSem = new Semaphore(1);
        hSem = new Semaphore(2);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hSem.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException ex) {
            throw new InterruptedException();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hSem.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		oSem.acquire();
        try {
            barrier.await();
        } catch (BrokenBarrierException ex) {
            throw new InterruptedException();
        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        oSem.release();
    }
}