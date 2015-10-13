package a_lambda;

class DifferenceBetweenLambdaAndAnonymousInnerClass {

    public static void main(String[] args) {
        Object innerclass = new Runnable() {
            @Override
            public void run() {
                System.out.println("playground");
            }
        };

        //Some books state that it is not possible to assign a lambda to an object. This is not true as we can
        //see here. The reason why
        //Object lambda = () -> System.out.println("test2");
        //does not work is only because the compiler needs to know the functional interface in order to create an
        //object.
        //In fact the compiler does not generate the object a compile time. The object is generated at runtime. The
        //compiler only creates an dynamic call which in turn uses "asm" to generate the object.
        Object lambda = (Runnable) () -> System.out.println("test2");

        ((Runnable)innerclass).run();
        ((Runnable)lambda).run();
    }

    /*
       0: new           #2                  // class learning/java/functional/interfaces/Test$1
       3: dup
       4: invokespecial #3                  // Method learning/java/functional/interfaces/Test$1."<init>":()V
       7: astore_1
       // This calls LambdaMetaFactory.metafactory in order to generate an object of the interface at !!runtime!!
       // According to Oracle this is because they want to be more flexible on how to generate the objects.
       8: invokedynamic #4,  0              // InvokeDynamic #0:run:()Ljava/lang/Runnable;
      13: astore_2
      14: aload_1
      15: checkcast     #5                  // class java/lang/Runnable
      18: invokeinterface #6,  1            // InterfaceMethod java/lang/Runnable.run:()V
      23: aload_2
      24: checkcast     #5                  // class java/lang/Runnable
      27: invokeinterface #6,  1            // InterfaceMethod java/lang/Runnable.run:()V
      32: return

     */

}