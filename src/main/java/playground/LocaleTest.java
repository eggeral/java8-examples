package playground;

import java.util.Arrays;
import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
        Locale[] locales = Locale.getAvailableLocales();
        Arrays.stream(locales).forEach(System.out::println);
        System.out.println("---");
        System.out.println(locales[1]);
        System.out.println(locales[1].getCountry());
        System.out.println(locales[1].getLanguage());
    }
}
