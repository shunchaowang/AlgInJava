package com.swang.alg.thread;

/**
 * Multi threading on instance level.
 */

public class SynchronizedInstanceThread {
   
    protected SynchronizedInstance instance = null;

    public SynchronizedInstanceThread(SynchronizedInstance instance) {
        this.instance = instance;
    }

    public void run() {
        for(int i = 0; i++; i< 10) {
            instance.add(i);
        }
    }
}




