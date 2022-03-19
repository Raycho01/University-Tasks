package SynchThreads;

public class Test {
    public static void main(String[] args) {

        AlphabetOrder sorter = new AlphabetOrder();

        Student1 st1 = new Student1(sorter);
        Student2 st2 = new Student2(sorter);

        st1.start();
        st2.start();

    }
}
