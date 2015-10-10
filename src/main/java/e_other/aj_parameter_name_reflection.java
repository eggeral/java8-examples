package e_other;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

class ParameterNameReflection {
    public static void main(String[] args) throws NoSuchMethodException {
        // Get rid of:
        // public Response getUserById(@PathParam("id") String id) {

        // recompile with -parameters!
        Method method = ParameterNameReflection.class.getMethod("testMethod", String.class);
        for (Parameter parameter : method.getParameters()) {
            System.out.println(parameter.getName());
        }
    }
    public void testMethod(String name) {

    }
}
