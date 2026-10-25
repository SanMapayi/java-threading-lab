public class ThreadOldAndEven {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread evenThread = new Thread(
                new EvenAndOddThread(printer, 20, true), "Even"
        );
        Thread oddThread = new Thread(
                new EvenAndOddThread(printer, 20, false), "Odd"
        );
        oddThread.start();
        evenThread.start();


    }

}

class EvenAndOddThread implements Runnable {
    final int max;
    boolean isEvenNumber;
    Printer printer;

    EvenAndOddThread(Printer printer, int max, boolean isEvenNumber){
        this.max = max;
        this.isEvenNumber = isEvenNumber;
        this.printer = printer;

    }

    @Override
    public void run() {
        int startNumber = isEvenNumber ? 2 : 1;
        while (startNumber <= max) {
            if (isEvenNumber){
                printer.printEven(startNumber);
            }
            else {
                printer.printOdd(startNumber);

            }
            startNumber += 2;
        }
    }
}
class Printer {

    volatile boolean isEvenTurn = false;
    public synchronized void printEven(int number) {
        while (!isEvenTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + number);
        isEvenTurn = false;
        notify();
    }

    public synchronized void printOdd(int number) {
        while(isEvenTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + number);
        isEvenTurn = true;
        notify();
    }
}
