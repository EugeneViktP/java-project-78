package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        var v = new Validator();
        var schema = v.string();
        System.out.println(schema.isValid(""));
        schema.required();
        System.out.println(schema.isValid(""));
//        System.out.println(schema.isValid(null));



    }
}
