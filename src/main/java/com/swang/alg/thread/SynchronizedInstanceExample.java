package com.swang.alg.thread;

public class SynchronizedInstanceExample {

    SynchronizedInstance instance = new SynchronizedInstance();

    Thread threadA = new SynchronizedInstanceThread(instance);
    Thread threadB = new SynchronizedInstanceThread(instance);

    threadA.start();
    threadB.start();
}
