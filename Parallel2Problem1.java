import java.util.concurrent.atomic.AtomicInteger;

public class Parallel2Problem1 {
    static int numGuests = 100; 
    static AtomicInteger guestsVisited = new AtomicInteger(0);

    public static void main(String[] args) {

        Thread[] guests = new Thread[numGuests];

        for (int i = 0; i < numGuests; i++) {
            guests[i] = new GuestThread(i);
            guests[i].start();
        }

        try {
            for (Thread thread : guests)
            {
                thread.join();
            }
        }
        catch (InterruptedException e) {}

        
    }

    private static class GuestThread extends Thread {
        boolean guestConsumedCake = false;
        int guestNumber;
        
        public GuestThread(int guestNumber) {
            this.guestNumber = guestNumber;
        }

        @Override
        public void run() {
            while (guestsVisited.get() < numGuests) {
                if (guestConsumedCake == false)
                {
                    guestsVisited.getAndIncrement();

                    try {
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e) {}
                    guestConsumedCake = true;

                    System.out.println("Guest " + this.guestNumber + " has entered maze and eaten cake");
                }
                else if (guestConsumedCake == true)
                {
                    try {
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e) {}
                    System.out.println("Guest " + this.guestNumber + " entered maze but did not eat cake");
                }
            }
        }
    }
}