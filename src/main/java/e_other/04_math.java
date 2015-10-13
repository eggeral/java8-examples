package e_other;

class Mathematics {
    public static void main(String[] args) {
        System.out.println(100_000 * 100_000);
        // System.out.println(Math.multiplyExact(100_000, 100_000));
        System.out.println(Math.addExact(100_000, 100_000));
        System.out.println("---");
        System.out.println(-5 % 2); // -1 is actually wrong. Euclid knew that!
        System.out.println(Math.floorMod(-5, 2));
        System.out.println(Math.floorMod(5, -2)); // -1 -> strange
        System.out.println("---");
        System.out.println(5 / 2);
        System.out.println(-5 / 2);
        System.out.println(Math.floorDiv(5, 2));
        System.out.println(Math.floorDiv(-5, 2));
        System.out.println("---");
        System.out.println(Math.nextDown(2.0)); // create the first value lower than x
    }
}
