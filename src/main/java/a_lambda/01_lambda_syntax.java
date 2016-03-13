package a_lambda;

import java.util.*;
import java.util.concurrent.CompletableFuture;


// Invented by Alonzo Church (1930) to formally study “computable functions” (algorithms)
//   * Equivalent to the “Turing Machine” but focuses on the software and not the machine.
//   * A very very simple programming language.

// Lambda example:
//
// Lets have a look at the following function:
//   sqsum(x,y) = x * x + y * y
//
// Lambda calculus is about anonymous functions
//   (x,y) -> x * x + y * y
//
// And there are some rules:
//
// Any function with more than one argument can be transformed into a function with just one argument (currying)
//   x -> ( y -> x * x* + y * y)
// And some others.
//
// Lambda calculus marks parameters with λ
//   λx.x+2
//   λx,y.( x * x + y * y  )  // 2 args
//   λx.λy.( x * x + y * y )  // 1 arg
//
// Lambda calculus is about variable substitution.
//   Data structures (eg. natural numbers) can be expressed as functions.

// Lambdas in Java 8:
//
// More or less the same as Church Lambdas.
//   Anonymous functions.
//   (String lhs, String rhs) -> lhs.compareToIgnoreCase(rhs)
//
//   λlhs.λrhs.lhs.compareToIgnoreCase(rhs)
class LambdaSyntax {

    public static void main(String[] args) {
        List<String> aList = Arrays.asList("aaaaaa", "bbb", "cccc");
        System.out.println("original: " + aList);

        //Lambda statements have code blocks and return statements.
        Collections.sort(aList, (String lhs, String rhs) -> {
            if (lhs.length() < rhs.length())
                return -1;
            else if (lhs.length() > rhs.length())
                return 1;
            else
                return 0;
        });
        System.out.println("sorted: " + aList);

        //If the compiler can figure out the type of the parameters the can be omitted.
        Collections.sort(aList, (lhs, rhs) -> {
            return Integer.compare(lhs.length(), rhs.length());
        });

        //If the lambda is not a code block the return statement is not needed.
        //The return type is always inferred by the compiler.
        Collections.sort(aList, (lhs, rhs) -> Integer.compare(lhs.length(), rhs.length()));

        //If the lambda has no parameters () still is needed.
        CompletableFuture.runAsync(() -> System.out.println("playground"));

        //If the lambda has only one parameter the () can be omitted.
        List<String> modifiableList = new ArrayList<>(aList);
        System.out.println("original: " + modifiableList);
        modifiableList.removeIf(element -> element.length() <= 3);
        System.out.println("removed: " + modifiableList);

    }
}
