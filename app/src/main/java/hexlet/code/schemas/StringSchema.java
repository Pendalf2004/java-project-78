package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public final StringSchema contains(String substring) {
        addCheck("containsSubStrCheck", item -> item.contains(substring));
        return this;
    }

    public final StringSchema required() {
        isRequired = true;
        addCheck("isNotEmpty", item -> !item.isEmpty());
        return this;
    }

    public final StringSchema minLength(int reqLength) {
        addCheck("minLengthCheck", item -> item.length() >= reqLength);
        return this;
    }
}
