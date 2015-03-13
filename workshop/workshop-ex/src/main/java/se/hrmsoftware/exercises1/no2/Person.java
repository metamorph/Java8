package se.hrmsoftware.exercises1.no2;

/**
 * Mr Bean, the person.
 * <p/>
 *
 * @author $Author: $
 */
public class Person {

    private final String name;
    private final int age;
    private final String email;
    private String telephoneNumber;

    public Person(final String name, final int age, final String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Person(final String name, final int age, final String email, String telephoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() { return telephoneNumber; }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
