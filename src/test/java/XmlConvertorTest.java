import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XmlConvertorTest {

    @Test
    public void shouldfilterNumber() throws IllegalAccessException {
        Book book = new Book("Ivanov", "Book name", 100);
        String expected = "<book>\n" +
                "\t<Pseudonym>Ivanov</Pseudonym>\n" +
                "\t<title>Book name</title>\n" +
                "</book>";
        assertEquals(expected, XmlConvertor.convertObject(book));
    }
}
