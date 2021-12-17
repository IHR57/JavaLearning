package Deadlock;

public class PhilosopherDemo {
    public void start() {
        Fork[] forks = new Fork[5];

        for(int i = 0; i < forks.length; i++) {
            forks[i] = new Fork();
        }

        Philosopher[] philosophers = new Philosopher[5];

        // will create deadlock -> create circular dependency which creates deadlock
//        for(int i = 0; i < philosophers.length; i++) {
//            Fork leftFork = forks[i];
//            Fork rightFork = forks[(i + 1) % forks.length];
//
//            philosophers[i] = new Philosopher("Philosopher " + i, leftFork, rightFork);
//            philosophers[i].start();
//        }

        // will not create deadlock
        for(int i = 0; i < philosophers.length; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % forks.length];

            if(i == philosophers.length - 1) {
                philosophers[i] = new Philosopher("Philosopher " + i, rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher("Philosopher " + i, leftFork, rightFork);
            }
            philosophers[i].start();
        }
    }
}
