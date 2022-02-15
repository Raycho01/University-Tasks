package Hash;

public class Test {
    public static void main(String[] args) {

        Person p1 = new Person("Ivan", "Ivanov", 25);
        Person p2 = new Person("Ivan", "Ivanov", 25);

        System.out.println((p1.hashing() == p2.hashing()));

    }
}
