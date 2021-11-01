import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws
            NoSuchMethodException,
            SecurityException,
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException {

        Book book = new Book("Ivanov", "Book name", 100);
        Class<XmlConvertor> clazz = XmlConvertor.class;
        Method method = clazz.getMethod("convertBook", Object.class);
        method.setAccessible(true);
        System.out.println(method.invoke(clazz, book));
    }
}
