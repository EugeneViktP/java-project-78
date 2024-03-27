package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        isRequired = true;
        addCriteria("required", x -> (x != null));
        return this;
    }

    public NumberSchema positive() {
        addCriteria("positive", x -> x > 0);
        return this;
    }

    public NumberSchema range(Integer lowLimit, Integer highLimit) {
        addCriteria("range", x -> ((x >= lowLimit) && (x <= highLimit)));
        return this;
    }
}
