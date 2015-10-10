package a_lambda;

import java.util.*;
import java.util.concurrent.CompletableFuture;

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
        CompletableFuture.runAsync(() -> System.out.println("test"));

        //If the lambda has only one parameter the () can be omitted.
        List<String> modifiableList = new ArrayList<>(aList);
        System.out.println("original: " + modifiableList);
        modifiableList.removeIf(element -> element.length() <= 3);
        System.out.println("removed: " + modifiableList);

    }
}
