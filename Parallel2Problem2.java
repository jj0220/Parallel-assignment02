import java.util.*;

public class Parallel2Problem2 {
    // choose second strategy

    static int numGuests = 50;
    static Object lock = new Object();
    static boolean available = true;


    public static void main(String [] args) {
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
        int guestNumber;
        
        public GuestThread(int guestNumber) {
            this.guestNumber = guestNumber;
        }

        @Override
        public void run() {
            synchronized (lock) {
                if (available) {
                    available = false;
                    System.out.println("Guest " + this.guestNumber + " is currently looking at the vase");
                    System.out.println("Guest " + this.guestNumber + " is finished looking at the vase");
                    available = true;
                }
            }
        }
    }
}
