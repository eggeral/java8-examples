package a_lambda;


class FibonacciIterative {
    public static void main(String[] args) {

        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(200));

    }

    public static long fibonacci(long n) {
        class Pair {
            long nminus2;
            long nminus1;

            Pair(long nminus2, long nminus1) {
                this.nminus2 = nminus2;
                this.nminus1 = nminus1;
            }
        }

        if (n == 0)
            return 1;
        if (n == 1)
            return 1;

        Pair current = new Pair(1, 1);
        for (int i = 2; i <= n; i++) {
            current = new Pair(current.nminus1, current.nminus2 + current.nminus1);
        }
        return current.nminus1;
    }
}
