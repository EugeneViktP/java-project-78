package hexlet.code.schemas;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {
    private List<Predicate<Object>> attributes = new ArrayList<>();
    public StringSchema required() {
        attributes.add(x -> !x.toString().isEmpty());
        System.out.println(attributes);
        return this;
    }
    public StringSchema minlength(int minLength) {
        attributes.add(x -> x.toString().length() > minLength);
        System.out.println(attributes);
        return this;
    }
    public StringSchema contains(String str) {
        attributes.add(x -> x.toString().contains(str));
        System.out.println(attributes);
        return this;

    }

    public boolean isValid(Object obj) {

        return attributes.stream().allMatch(x -> x.test(obj));
    }
}
