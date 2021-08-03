import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GeneratePerson {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static Person generatePerson() {
        Person person = new Person();
        person.setName(faker.name().firstName());
        person.setSurname(faker.name().lastName());
        person.setAddress(faker.address().fullAddress());
        person.setAge(Integer.toString(10 + random.nextInt(60)));
        return person;
    }

    public static List<Person> generatePersonList() {
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            people.add(generatePerson());
        }
        List<Person> collect = people.stream().
                sorted(new ComparatorForPerson())
                .collect(Collectors.toList());
        return collect;
    }
}
