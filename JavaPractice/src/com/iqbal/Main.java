package com.iqbal;

import com.iqbal.ThreadJoin.Runner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Thread Join Example
        Runner runner = new Runner();
        runner.run();


    }

    private static void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}