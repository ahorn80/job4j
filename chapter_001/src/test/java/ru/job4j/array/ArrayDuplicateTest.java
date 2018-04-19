package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate duplicateSearch = new ArrayDuplicate();
        String[] inputStrings = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expectedStrings = {"Привет", "Мир", "Супер"};
        String[] resultStrings = duplicateSearch.remove(inputStrings);
        assertThat(resultStrings, is(expectedStrings));
    }

    @Test
    public void whenDuplicateOnlyArrayThenSingleString() {
        ArrayDuplicate duplicateSearch = new ArrayDuplicate();
        String[] inputStrings = {"2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2", "2" };
        String[] expectedStrings = {"2"};
        String[] resultStrings = duplicateSearch.remove(inputStrings);
        assertThat(resultStrings, is(expectedStrings));
    }

    @Test
    public void whenNoDuplicatesArrayThenSameArray() {
        ArrayDuplicate duplicateSearch = new ArrayDuplicate();
        String[] inputStrings = {"1", "2", "3", "4"};
        String[] expectedStrings = {"1", "2", "3", "4"};
        String[] resultStrings = duplicateSearch.remove(inputStrings);
        assertThat(resultStrings, is(expectedStrings));
    }

    @Test
    public void whenSingleStringArrayThenSameArray() {
        ArrayDuplicate duplicateSearch = new ArrayDuplicate();
        String[] inputStrings = {"1"};
        String[] expectedStrings = {"1"};
        String[] resultStrings = duplicateSearch.remove(inputStrings);
        assertThat(resultStrings, is(expectedStrings));
    }

}