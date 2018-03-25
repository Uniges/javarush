package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public synchronized void someMethod() {
        //implement logic here, use the lock field
        try {
            boolean b = lock.tryLock();
            if (!b) {
                ifLockIsBusy();
            }
            else if (b) {
                ifLockIsFree();
            }
        } catch (Exception e) {
            //lock.unlock();
        } finally {
            lock.unlock();
        }
    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}
