import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {

    PhoneBook book;

    @BeforeEach
    public void set() {
        book = new PhoneBook();
    }

    @AfterEach
    public void clean() {
        book = null;
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
        String expectedResult = "Carl";

        //act
        book.add(name, number);
        String result = book.findByNumber("8 800 555 35 36");

        //assert
        Assertions.assertEquals(expectedResult, result);
    }



}
