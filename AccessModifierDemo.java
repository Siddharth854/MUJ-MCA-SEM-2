package access_modifier;

// public class (file name must match)
public class AccessModifierDemo {

    public void publicMethod() {
        System.out.println("Public method");
    }

    protected void protectedMethod() {
        System.out.println("Protected method");
    }

    void defaultMethod() {
        System.out.println("Default method");
    }

    private void privateMethod() {
        System.out.println("Private method");
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo();

        obj.publicMethod();
        obj.protectedMethod();
        obj.defaultMethod();
        obj.privateMethod(); // allowed inside same class
    }
}

// default access class
class AnotherClass {

    void testAccess() {
        AccessModifierDemo obj = new AccessModifierDemo();

        obj.publicMethod();      // ✅
        obj.protectedMethod();   // ✅ (same package)
        obj.defaultMethod();     // ✅ (same package)
        // obj.privateMethod();  // ❌ not accessible
    }
}
