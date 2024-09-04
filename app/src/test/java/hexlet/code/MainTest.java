package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    Validator valid;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        valid = new Validator();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testStringValidation() {
        var stringSchema = valid.string();
        assertThat(stringSchema.isValid()).isTrue();
        stringSchema.required();
        assertThat(stringSchema.isValid()).isFalse();
        stringSchema = valid.string();
        stringSchema.contains("a");
        assertThat(stringSchema.isValid("a")).isTrue();
        assertThat(stringSchema.isValid("b")).isFalse();
        stringSchema.minLength(2);
        assertThat(stringSchema.isValid("a")).isFalse();
        assertThat(stringSchema.isValid("aa")).isTrue();
    }
}