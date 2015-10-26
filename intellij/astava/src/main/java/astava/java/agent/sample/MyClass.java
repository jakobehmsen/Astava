package astava.java.agent.sample;

import java.io.Serializable;

@MyAnnotation(value = 333, extra = "bla")
public class MyClass extends MyOtherClass {
    public String someField;
    public String someOtherField;

    public MyClass() {

    }

    public MyClass(String dummy) {

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean someMethod(int arg0, int arg1) {
        return false;
    }

    public boolean someOtherMethod(int arg0, int arg1, @MyNotNullAnnotation String str) {
        return false;
    }

    @MyNotNullAnnotation
    private boolean someOtherMethod2(String str1, String str2) {
        return false;
    }

    @MyNotNullAnnotation
    public boolean someOtherMethod3(String str1, String str2) {
        System.out.println("Within someOtherMethod3");
        return true;
    }

    @MyNotNullAnnotation
    public void someOtherMethod4(String str1, String str2) {
        System.out.println("Within someOtherMethod4");
    }
}
