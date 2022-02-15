package SynchThreads;

public class Student2 extends Thread{

    AlphabetOrder name;

    public Student2(AlphabetOrder name){
        this.name = name;
    }

    public void run(){
        name.printName("Brad");
    }

}
