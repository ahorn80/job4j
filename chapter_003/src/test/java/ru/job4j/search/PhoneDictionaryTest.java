package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Andreas", "Horn", "0911123456", "Nürnberg")
        );
        List<Person> persons = phones.find("Andreas");
        assertThat(persons.iterator().next().getSurname(), is("Horn"));
    }

    @Test
    public void whenFindBySurName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Andreas", "Horn", "0911123456", "Nürnberg")
        );
        List<Person> persons = phones.find("Andr");
        assertThat(persons.iterator().next().getSurname(), is("Horn"));
    }

    @Test
    public void whenFindByPhonePart() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Andreas", "Horn", "0911123456", "Nürnberg")
        );
        List<Person> persons = phones.find("1234");
        assertThat(persons.iterator().next().getSurname(), is("Horn"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Andreas", "Horn", "0911123456", "Nürnberg")
        );
        List<Person> persons = phones.find("Nürnberg");
        assertThat(persons.iterator().next().getSurname(), is("Horn"));
    }
}