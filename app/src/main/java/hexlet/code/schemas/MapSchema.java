package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map> {
    public MapSchema required() {
        isRequired = true;
        addCriteria("required", x -> (x != null));
        return this;
    }

    public MapSchema sizeof(int size) {
        addCriteria("sizeof", x -> x.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> data) {
        addCriteria("shape", x -> data.entrySet()
                .stream()
                .allMatch(entry -> {
                    var key = entry.getKey();
                    var value = entry.getValue();
                    return value.isValid((String) x.get(key));
                })
        );
        return this;
    }
}
