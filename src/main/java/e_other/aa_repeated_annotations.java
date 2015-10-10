package e_other;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({ TYPE, TYPE_USE, METHOD, PARAMETER, FIELD })
@Repeatable(value = Marks.class)
@interface MarkIt {
    String tag();
}

@Retention(RUNTIME)
@Target({ TYPE, TYPE_USE, METHOD, PARAMETER, FIELD })
@interface Marks {
    MarkIt[] value();
}
class RepeatedAnnotations {
    // Previous to Java 8
    @Marks(value = { @MarkIt(tag = "test1"), @MarkIt(tag = "test2") })
    public void java7() {
    }

    // Now we can ommit the @Marks at least when using it. For the declaration
    // of the Annotations this is still neede!
    @MarkIt(tag = "java8test1")
    @MarkIt(tag = "java8test2")
    public void java8() {
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Marks java7Marks = RepeatedAnnotations.class.getMethod("java7").getAnnotation(Marks.class);
        for (MarkIt markIt : java7Marks.value()) {
            System.out.println(markIt.tag());
        }

        System.out.println("---");
        Marks java8Marks = RepeatedAnnotations.class.getMethod("java7").getAnnotation(Marks.class);
        for (MarkIt markIt : java8Marks.value()) {
            System.out.println(markIt.tag());
        }

    }
}
