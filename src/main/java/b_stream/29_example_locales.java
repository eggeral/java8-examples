package b_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Locales {

    public static void main(String[] args) throws IOException {
        Stream<Locale> locales = Arrays.stream(Locale.getAvailableLocales());

        // locales english / not english
        System.out.println(locales.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en"))));

        // locales grouped by country
        locales = Arrays.stream(Locale.getAvailableLocales());
        System.out.println(locales.collect(Collectors.groupingBy(l -> l.getCountry())));

    }
}
