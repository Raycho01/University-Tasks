package SynchThreads;

public class Student1 extends Thread{

    AlphabetOrder name;

    public Student1(AlphabetOrder name){
        this.name = name;
    }

    public void run(){
        name.printName("Alex");
    }

}
