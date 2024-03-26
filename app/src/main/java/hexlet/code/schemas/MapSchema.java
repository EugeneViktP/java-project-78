package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map> {
    public MapSchema required() {
        addCriteria("required", x -> (x != null));
        return this;
    }
    public MapSchema sizeof(int size) {
        addCriteria("sizeof", x -> x.size() == size);
        return this;
    }

}
