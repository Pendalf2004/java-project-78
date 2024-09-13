package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    private Validator valid;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        valid = new Validator();
    }

    @Test
    void testStringValidation() {
        var stringSchema = valid.string();
        assertThat(stringSchema.isValid(null)).isTrue();
        stringSchema.required();
        assertThat(stringSchema.isValid(null)).isFalse();
        stringSchema = valid.string();
        stringSchema.contains("a");
        assertThat(stringSchema.isValid("a")).isTrue();
        assertThat(stringSchema.isValid("b")).isFalse();
        stringSchema.minLength(2);
        assertThat(stringSchema.isValid("a")).isFalse();
        assertThat(stringSchema.isValid("aa")).isTrue();
    }
    @Test
    void testNumValidation() {
        var numSchema = valid.number();
        assertThat(numSchema.isValid(null)).isTrue();
        numSchema.required();
        assertThat(numSchema.isValid(null)).isFalse();
        numSchema = valid.number();
        numSchema.positive();
        assertThat(numSchema.isValid(1)).isTrue();
        assertThat(numSchema.isValid(0)).isFalse();
        numSchema.range(2, 3);
        assertThat(numSchema.isValid(1)).isFalse();
        assertThat(numSchema.isValid(null)).isTrue();
    }
    @Test
    void testMapValidation() {
        var mapSchema = valid.map();
        Map<String, BaseSchema<String>>  mapValidation = new HashMap<>();
        mapValidation = new HashMap<>();
        mapValidation.put("firstName", valid.string().required());
        mapValidation.put("lastName", valid.string().required().minLength(2));
        mapSchema.shape(mapValidation);
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertThat(mapSchema.isValid(human1)).isTrue();

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertThat(mapSchema.isValid(human2)).isFalse();

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertThat(mapSchema.isValid(human3)).isFalse();
    }

    @Test
    void additionalNumTest() {
        var v = new Validator();
        var schema = v.number();

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.positive();
        assertThat(schema.isValid(null)).isTrue();
    }
}
