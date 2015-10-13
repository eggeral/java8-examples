package e_other;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class NullChecks {
    public static void main(String[] args) {
        System.out.println(Objects.isNull(null));
        System.out.println(Objects.isNull(new Object()));
        System.out.println("---");
        System.out.println(Objects.nonNull(null));
        System.out.println(Objects.nonNull(new Object()));
        System.out.println("---");

        List<String> strs = Arrays.asList("1",null,"3","4","5",null);
        strs.stream().filter(Objects::isNull).forEach(System.out::println);
        System.out.println("---");
        strs.stream().filter(Objects::nonNull).forEach(System.out::println);
        System.out.println("---");
    }
}
