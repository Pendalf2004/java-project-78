package hexlet.code;
import hexlet.code.schemas.*;

public class Validator {

    public Validator() {
    }

    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }
}
