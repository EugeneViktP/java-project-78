package hexlet.code.schemas;
import java.util.Collection;
import java.util.Map;

import java.util.LinkedHashMap;
import java.util.function.Predicate;

abstract class BaseSchema<T> {
    private Map<String, Predicate<T>> attributes = new LinkedHashMap<>();

    public boolean isValid(T obj) {
        Collection<Predicate<T>> data = attributes.values();
        if (obj == null && data.isEmpty()) {
            return true;
        } else if (obj == null) {
            return false;
        }
        return data.stream().allMatch(x -> x.test(obj));
    }
    public void addCriteria(String name, Predicate<T> criterion) {

        attributes.put(name, criterion);
    }
}
