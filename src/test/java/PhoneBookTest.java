import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PhoneBookTest {

    PhoneBook book;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void set() {
        book = new PhoneBook();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void clean() {
        book = null;
        System.setOut(null);
    }

    @Test
    public void addTest() {
        //arrange
        String name = "Carl";
        String number = "8 800 555 35 35";

        String name1 = "Alice";
        String number1 = "8 800 555 35 35";

        int expectedResult = 2;
        //act
        book.add(name, number);
        int result = book.add(name1, number1);

        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void addTestSameName() {
        //arrange
        String name = "Carl";
        String number = "8 800 555 35 35";

        String name1 = "Carl";
        String number1 = "8 800 555 35 35";

        int expectedResult = 1;
        //act
        book.add(name, number);
        int result = book.add(name1, number1);

        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void findByNumberTrueTest() {
        //arrange
        String name = "Carl";
        String number = "8 800 555 35 35";
        String expectedResult = "Carl";

        //act
        book.add(name, number);
        String result = book.findByNumber(number);

        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void findByNumberFalseTest() {
        //arrange
        String name = "Carl";
        String number = "8 800 555 35 35";

        //act
        book.add(name, number);
        String result = book.findByNumber("8 800 555 35 36");

        //assert
        Assertions.assertEquals(null, result);
    }

    @Test
    public void findByNameTrueTest() {
        //arrange
        String name = "Carl";
        String number = "8 800 555 35 35";

        String name1 = "Alice";
        String number1 = "8 800 555 35 35";

        String expectedResult = "8 800 555 35 35";
        //act
        book.add(name, number);
        book.add(name1, number1);

        String result = book.findByName("Alice");

        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void findByNameFalseTest() {
        //arrange
        String name = "Carl";
        String number = "8 800 555 35 35";

        String name1 = "Alice";
        String number1 = "8 800 555 35 35";

        String expectedResult = null;
        //act
        book.add(name, number);
        book.add(name1, number1);

        String result = book.findByName("Alica");

        //assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void printAllNamesTest() {
        //arrange
        String name = "Carl";
        String number = "8 800 555 35 35";

        String name1 = "Alice";
        String number1 = "8 800 555 35 35";

        String expectedResult = "Alice\r\nCarl\r\n";
        //act
        book.add(name, number);
        book.add(name1, number1);

        book.printAllNames();

        //assert
        Assertions.assertEquals(expectedResult, output.toString());

    }


}
