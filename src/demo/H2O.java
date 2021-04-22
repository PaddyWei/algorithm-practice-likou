package demo;

import java.util.concurrent.Semaphore;

/**
 * @ClassName : H2O
 * @Description : 水分子
 * @Author : DukeWei
 * @Date : 2020/12/14 16:07
 * @Version : 1.0
 **/
public class H2O {

    public H2O() {

    }

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }

}
