package hexlet.code.schemas;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {
    private List<Predicate<Object>> attributes = new ArrayList<>();
    public StringSchema required() {
        attributes.add(x -> !x.toString().isEmpty());
        return this;
    }
    public StringSchema minlength(int minLength) {
        attributes.add(x -> x.toString().length() > minLength);
        return this;
    }
    public StringSchema contains(String str) {
        attributes.add(x -> x.toString().contains(str));
        return this;

    }

    public boolean isValid(Object obj) {
        if (obj == null && attributes.isEmpty()) {
            return true;
        } else if (obj == null) {
            return false;
        }
        return attributes.stream().allMatch(x -> x.test(obj));
    }
}
