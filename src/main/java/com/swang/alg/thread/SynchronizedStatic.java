package com.swang.alg.thread;

/**
 * Java synchronzed keyword can be used on instance method and block,
 * as well as on static method and block of class level.
 * This class is demonstrating synchronized on method and block of the class.
 * Under this circumstance the synchronized monitor is the class owning 
 * the method and block. It's called the method or block is synchronized on 
 * the current class. 
 */

public class SynchronizedStatic {

    private static int count = 0;

    /**
     * This instance method is synchronized on its owning object.
     */
    public static synchronized void add(int value) {
        this.count += value;
    }

    /**
     * This method does not have any synchronized keyword, 
     * but it contains a synchronized block in its body.
     */
    public void minus(int value) {
        // this block is synchronized on the owning class
        synchronized(com.swang.alg.thread.SynchronizedStatic.class) {
            this.count -= value;
        }
    }
}
