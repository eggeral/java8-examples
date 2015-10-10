package e_other;

import java.math.BigDecimal;
import java.util.stream.Stream;

class NumberOperations {
    public static void main(String[] args) {
        System.out.println(Integer.SIZE);
        System.out.println(Integer.BYTES); //LOL
        System.out.println("---");
        System.out.println(Long.hashCode(25));
        System.out.println(Long.hashCode(1_000_000_000_000l));
        System.out.println("---");
        System.out.println(Integer.sum(1, 2));
        // This is useful for stream reductions
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum));
        System.out.println(Stream.of(true, true, false, false).reduce(Boolean::logicalOr));
        System.out.println(Stream.of(true, true, false, false).reduce(Boolean::logicalAnd));
        System.out.println("---");

        System.out.println(Double.isFinite(1));
        System.out.println(Double.isFinite(Double.NaN));
        System.out.println(Double.isFinite(Double.POSITIVE_INFINITY));
        System.out.println(Double.isFinite(Double.NEGATIVE_INFINITY));

        System.out.println("---");

        BigDecimal bigDecimal = BigDecimal.valueOf(Long.MAX_VALUE);
        System.out.println(bigDecimal.intValue());
//        System.out.println(bigDecimal.intValueExact());
        System.out.println("---");

        // Working with unsigned values
        byte byteTest = (byte) 255;
        System.out.println(byteTest);
        System.out.println(Byte.toUnsignedInt(byteTest));
        int intTest = (int) 1_000_000_000l;
        System.out.println(Integer.toUnsignedString(intTest));

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE + 1;
        System.out.println(x);
        System.out.println(y);
        System.out.println(Integer.compare(1, 2));
        System.out.println(Integer.compare(x, y));
        System.out.println(Integer.compareUnsigned(x, y));
        System.out.println("---");

        System.out.println(y / x);
        System.out.println(Integer.divideUnsigned(y, x));
        System.out.println(y % x);
        System.out.println(Integer.remainderUnsigned(y, x));

        System.out.println("---");
        System.out.println(Integer.parseUnsignedInt("2147483648"));
        System.out.println(Integer.parseInt("2147483648"));
    }
}
