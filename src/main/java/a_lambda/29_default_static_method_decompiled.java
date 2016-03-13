package a_lambda;

interface DefaultAndStatic {
    default void print() {
        System.out.println("Default method");
    }

    static void printStatic() {
        System.out.println("Static method");
    }
}

/*
interface a_lambda.DefaultAndStatic {
  public void print();
    Code:
       0: getstatic     #1                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #2                  // String Default method
       5: invokevirtual #3                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return

  public static void printStatic();
    Code:
       0: getstatic     #1                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #4                  // String Static method
       5: invokevirtual #3                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
 */

class DefaultAndStaticMethodsDecompiled {
    public static void main(String[] args) {
        DefaultAndStatic.printStatic();


        DefaultAndStatic defaultAndStatic = new DefaultAndStatic() {
            // create an anonymous inner class
        };

        defaultAndStatic.print();
    }

    /*
     public static void main(java.lang.String[]);
    Code:
       // static methods just get called
       0: invokestatic  #2                  // InterfaceMethod a_lambda/DefaultAndStatic.printStatic:()V
       3: new           #3                  // class a_lambda/DefaultAndStaticMethodsDecompiled$1
       6: dup
       7: invokespecial #4                  // Method a_lambda/DefaultAndStaticMethodsDecompiled$1."<init>":()V
      10: astore_1
      11: aload_1
      12: invokeinterface #5,  1            // InterfaceMethod a_lambda/DefaultAndStatic.print:()V
      29: return
     */
}
