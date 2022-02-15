package Hash;

import java.util.Objects;

public class Person {

        private String firstName;
        private String familyName;
        private int years;

        public Person(String firstName, String familyName, int years) {
            this.firstName = firstName;
            this.familyName = familyName;
            this.years = years;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getFamilyName() {
            return familyName;
        }

        public void setFamilyName(String familyName) {
            this.familyName = familyName;
        }

        public int getYears() {
            return years;
        }

        public void setYears(int years) {
            this.years = years;
        }



    public boolean equals1(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return years == person.years && familyName.equals(person.familyName);
    }

    public int hashing(){
        int result = 332;
        result = result + this.firstName.hashCode();
        result = result + this.familyName.hashCode();
        result = result * this.years;
        return result;
    }


}