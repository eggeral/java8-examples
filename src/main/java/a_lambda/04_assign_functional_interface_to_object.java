package a_lambda;

class AssignFunctionalInterfaceToObject {
    interface IntFunction {
        int apply (int x);
    }

    public static void main(String[] args) {
        //Some books state that you can not assign a lambda to object
        //because object is not a functional interface.
        //This is not true!

        IntFunction function1 = x -> x * 5; //We know that

        //Object function2 = x -> x * 5; //This does not work

        //The reason why it does not work is that the compiler has no idea
        //which functional interface should be implemented.
        //A small hint to the compiler solves that "problem"

        Object function3 = (IntFunction) x -> x * 5;

        //Some books even say that the Java VM was changed. That the rule was broken, that
        //everything is an object. As we see that is not true!
    }

}
