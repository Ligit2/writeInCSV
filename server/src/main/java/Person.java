public class Person {
    private String name;
    private String surname;
    private String age;
    private String address;

    public Person(String name, String surname, String age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Person() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return
                "name='" + name + '\'' + " surname='" + surname + '\'' + " age='" + age + '\'' + " address='" + address + '\'';
    }
}
