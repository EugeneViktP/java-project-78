package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        isRequired = true;
        addCriteria("required", x -> !x.isEmpty());
        return this;
    }

    public StringSchema minLength(int minLength) {
        addCriteria("minLength", x -> x.length() > minLength);
        return this;
    }

    public StringSchema contains(String str) {
        addCriteria("contains", x -> x.contains(str));
        return this;
    }
}
