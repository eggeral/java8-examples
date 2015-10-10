package e_other;

class TypeUsageAnnotations {

    public static void main(String[] args) {
        //Type usage annotation can only be accessed by the compiler (see http://types.cs.washington.edu/checker-framework/)
        @MarkIt(tag = "local var tag") String msg = "hello world";
        // This is supposed to be used for compile checks. @NotNull etc. Nevertheless
        // it is pretty useless as these checks are not supported by the java compiler itself
    }
}
