package a_lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class JavaAlwaysHadLambdas {

    // at least sort of ...
    public static void main(String[] args) {
        // A lambda is a piece of code you want to be executed "later" or "somewhere else".
        List<String> aList = Arrays.asList("z", "B", "a");
        System.out.println("original:\t" + aList);

        //Lets sort the list
        Collections.sort(aList); //Sorts the list. But case sensitive!
        System.out.println("sorted:\t\t" + aList);

        //Case insensitive sort the very old way!
        Collections.sort(aList, new CaseInsensitiveStringComparator()); //Sorts the list case insensitive
        //There are better ways to do this in Java 8! We will have a look at them later!
        System.out.println("comparator:\t" + aList);

        //Java 1.1 gave us anonymous inner classes.
        //The list is already sorted so lets shuffle it.
        Collections.shuffle(aList);
        System.out.println("shuffled:\t" + aList);

        Collections.sort(aList, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.compareToIgnoreCase(rhs);
            }
        });
        System.out.println("anonymous:\t" + aList);

        //Java 8 gives us Lambdas for that
        Collections.shuffle(aList);
        Collections.sort(aList, (String lhs, String rhs) -> lhs.compareToIgnoreCase(rhs));
        System.out.println("lambda:\t\t" + aList);

        //Nice but there is more!

    }

    private static class CaseInsensitiveStringComparator implements Comparator<String> {
        @Override
        public int compare(String lhs, String rhs) {
            return lhs.compareToIgnoreCase(rhs);
        }
    }
}
