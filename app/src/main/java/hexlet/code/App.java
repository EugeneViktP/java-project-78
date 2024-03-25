package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        var v = new Validator();
//        var schema = v.string();
////        System.out.println(schema.isValid(""));
//        schema.required();
////        System.out.println(schema.isValid(""));
////        System.out.println(schema.isValid(null));
//        schema.minlength(7).minlength(4);
//        System.out.println(schema.isValid("Mother"));
        var schema = v.number();
//        System.out.println(schema.isValid(null));
        schema.required();
//        System.out.println(schema.isValid(null));
        schema.range(6, 12);
        System.out.println(schema.isValid(7));
        System.out.println(schema.isValid(13));
        System.out.println(schema.isValid(12));
    }
}
