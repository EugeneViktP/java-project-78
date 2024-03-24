package hexlet.code;

import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.StringSchemaMap;

public class Validator {
    public Validator() {
    }
    public static StringSchema string() {

        return new StringSchema();
    }
    public static StringSchemaMap string2() {
        return new StringSchemaMap();
    }
}
