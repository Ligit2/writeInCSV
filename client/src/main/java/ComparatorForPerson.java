import java.util.Comparator;

public class ComparatorForPerson implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getSurname().compareTo(o2.getSurname()) == 0) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }
}
