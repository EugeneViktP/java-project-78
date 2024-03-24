package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
//    private Map<String, Predicate<String>> attributes = new LinkedHashMap<>();
    public StringSchema required() {
        addCriteria("required", x -> !x.isEmpty());
        return this;
    }
    public StringSchema minlength(int minLength) {
        addCriteria("minLength", x -> x.length() > minLength);
        return this;
    }
    public StringSchema contains(String str) {
        addCriteria("contains", x -> x.contains(str));
        return this;

    }

//    public boolean isValid(String obj) {
//        Collection<Predicate<Object>> data = attributes.values();
//        if (obj == null && attributes.isEmpty()) {
//            return true;
//        } else if (obj == null) {
//            return false;
//        }
//        return data.stream().allMatch(x -> x.test(obj));
//    }
}
