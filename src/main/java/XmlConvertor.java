import java.lang.reflect.Field;
import java.util.Locale;

public class XmlConvertor {

//<book>
//  <title>Book name</title>
//  <pages>100</pages>
//</book>

    public static String convertBook(Object any) throws
            IllegalAccessException {

        final StringBuilder sb = new StringBuilder();
        Class<?> clazz = any.getClass();
        String className = clazz.getSimpleName().toLowerCase(Locale.ROOT);
        Field[] infoFields = clazz.getDeclaredFields();

        sb.append("<")
                .append(className)
                .append(">");
        for (Field fieldName : infoFields) {
            fieldName.setAccessible(true);
            String name = fieldName.get(any).toString();
            if (!fieldName.isAnnotationPresent(Ignore.class)) {
                if (fieldName.isAnnotationPresent(Pseudonym.class)) {
                    Pseudonym pseudonym = fieldName.getAnnotation(Pseudonym.class);
                    name = pseudonym.value();
                }
                sb.append("\n\t<")
                        .append(fieldName.getName())
                        .append(">")
                        .append(name)
                        .append("</")
                        .append(fieldName.getName())
                        .append(">");
            }
        }
        sb.append("\n</")
                .append(className)
                .append(">");
        return sb.toString();
    }
}