class DiningPhilosophers {
    public static void main(String args[]) {
        Semaphore chopSticks[];
        Semaphore arbitrator = new Semaphore(4);
        Philosopher workerThread[];

        chopSticks = new Semaphore[5];

        for (int i = 0; i < 5; i++)
            chopSticks[i] = new Semaphore(1);

        workerThread = new Philosopher[5];

        for (int i = 0; i < 5; i++) {
            workerThread[i] = new Philosopher(i, chopSticks, arbitrator);
            workerThread[i].start();
        }
    }
}

class Philosopher extends Thread {
    private int myName;
    private Semaphore chopSticks[];
    private Semaphore arbitrator;

    public Philosopher(int myName, Semaphore chopSticks[], Semaphore arbitrator) {
        this.myName = myName;
        this.chopSticks = chopSticks;
        this.arbitrator = arbitrator;
    }

    public void run() {
        while (true) {
            System.out.println("Philosopher " + myName + " thinking.");
            try {
                sleep((int) (Math.random() * 20000));
            } catch (InterruptedException e) {}

            arbitrator.acquire(); // Acquire permission to proceed
            chopSticks[myName].acquire(); // Acquire right
            chopSticks[(myName + 1) % 5].acquire(); // Acquire left

            System.out.println("Philosopher " + myName + " eating.");
            try {
                sleep((int) (Math.random() * 10000));
            } catch (InterruptedException e) {}

            chopSticks[myName].release(); // Release right
            chopSticks[(myName + 1) % 5].release(); // Release left
            arbitrator.release(); // Release the permission
        }
    }
}

