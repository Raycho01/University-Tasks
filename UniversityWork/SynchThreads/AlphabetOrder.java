package SynchThreads;

public class AlphabetOrder {

    synchronized void printName(String name){

        for (int i = 0; i < 5; i++) {
            System.out.println(name);

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}


