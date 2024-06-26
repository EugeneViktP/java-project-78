package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringSchemaTest {
    @Test
    public void test1() {
        Validator v = new Validator();
        StringSchema schema = Validator.string();
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        schema.minLength(4);
        assertTrue(schema.isValid("Mother"));
        assertFalse(schema.isValid("Cat"));
        schema.contains("Mo");
        assertTrue(schema.isValid("Mother"));
        assertFalse(schema.isValid("Cat"));
    }

    @Test
    public void test2() {
        Validator v = new Validator();
        StringSchema schema1 = Validator.string();
        schema1.required().contains("Mo").minLength(4);
        assertTrue(schema1.isValid("Mother"));
    }
}
