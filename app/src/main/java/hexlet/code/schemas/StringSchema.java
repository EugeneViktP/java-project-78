package hexlet.code.schemas;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StringSchema {
    private Map<String, Predicate<Object>> attributes = new LinkedHashMap<>();
    public StringSchema required() {
        attributes.put("required", x -> !x.toString().isEmpty());
        return this;
    }
    public StringSchema minlength(int minLength) {
        attributes.put("minLength", x -> x.toString().length() > minLength);
        return this;
    }
    public StringSchema contains(String str) {
        attributes.put("contains", x -> x.toString().contains(str));
        return this;

    }

    public boolean isValid(Object obj) {
        Collection<Predicate<Object>> data = attributes.values();
        if (obj == null && attributes.isEmpty()) {
            return true;
        } else if (obj == null) {
            return false;
        }
        return data.stream().allMatch(x -> x.test(obj));
    }
}
