public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Book book = new Book("Ivanov", "Book name", 100);
        System.out.println(XmlConvertor.convertObject(book));
    }
}
