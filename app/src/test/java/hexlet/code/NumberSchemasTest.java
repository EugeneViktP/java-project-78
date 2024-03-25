package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemasTest {
    @Test
    public void test1() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
        schema.positive();
        assertTrue(schema.isValid(5));
        assertFalse(schema.isValid(-5));
        schema.range(3, 9);
        assertFalse(schema.isValid(2));
        assertTrue(schema.isValid(3));
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(9));
        assertFalse(schema.isValid(10));
    }
//    @Test
//    public void test2() {
//        Validator v = new Validator();
//        NumberSchema schema1 = v.number();
//        assertTrue(schema1.positive().isValid(null));
//    }
}
