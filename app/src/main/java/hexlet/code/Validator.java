package hexlet.code;

import hexlet.code.schemas.StringSchema;

import java.util.Objects;

public class Validator {
    public Validator() {
    }
    public static StringSchema string() {
        return new StringSchema();
    }
}
