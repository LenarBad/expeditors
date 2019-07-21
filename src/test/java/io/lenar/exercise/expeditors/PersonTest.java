package io.lenar.exercise.expeditors;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PersonTest {

    @DataProvider
    public Object[][] personFieldData() {
        return new Object[][] {
                {"\"abc 123 Abc\"", "ABC 123 ABC"},
                {"\"abc 123, Abc\"", "ABC 123 ABC"},
                {"\" abc 123, Abc\"", "ABC 123 ABC"},
                {"\" abc 123, Abc \"", "ABC 123 ABC"},
                {"\" abc. 123, Abc \"", "ABC 123 ABC"}
        };
    }

    @Test(dataProvider = "personFieldData")
    public void clearAndCleanAddressLine(String inputField, String expectedField) {
        Person person = new Person(String.format("\"Eve\",\"Smith\",%s,\"Tacoma\",\"WA\",\"25\"", inputField));
        assertEquals(person.getAddress(), expectedField + ", TACOMA, WA");
    }

    @Test(dataProvider = "personFieldData")
    public void clearAndCleanCity(String inputField, String expectedField) {
        Person person = new Person(String.format("\"John\",\"Smith\",\"addressline\",%s,\"WA\",\"25\"", inputField));
        assertEquals(person.getAddress(), "ADDRESSLINE, " + expectedField + ", WA");
    }

    @Test(dataProvider = "personFieldData")
    public void clearAndCleanFirstName(String inputField, String expectedField) {
        Person person = new Person(String.format("%s,\"Smith\",\"abc 123 Abc\",\"Tacoma\",\"WA\",\"25\"", inputField));
        assertEquals(person.getFirstName(), expectedField);
    }

    @Test(dataProvider = "personFieldData")
    public void clearAndCleanLastName(String inputField, String expectedField) {
        Person person = new Person(String.format("\"John\",%s,\"abc 123 Abc\",\"Tacoma\",\"WA\",\"25\"", inputField));
        assertEquals(person.getLastName(), expectedField);
    }

    @DataProvider
    public Object[][] ageData() {
        return new Object[][] {
                {"\"0\"", false},
                {"\"17\"", false},
                {"\"18\"", true},
                {"\"19\"", true},
                {"\"100\"", true}
        };
    }

    @Test(dataProvider = "ageData")
    public void isAdult(String inputField, boolean adult) {
        Person person = new Person(String.format("\"John\",\"Doe\",\"abc 123 Abc\",\"Tacoma\",\"WA\",%s", inputField));
        assertEquals(person.isAdult(), adult);
    }

    @Test
    public void toStringTest() {
        Person person = new Person("\"John\",\"Doe\",\"abc 123\",\"Tacoma\",\"WA\",\"18\"");
        assertEquals(person.toString(), "DOE JOHN, ABC 123, TACOMA, WA, 18");
    }
}
