package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema contains(String substring) {
        addCheck("containsSubStrCheck", item -> item.contains(substring));
        return this;
    }

    public StringSchema required() {
        isRequered = true;
        return this;
    }

    public StringSchema minLength(int reqLength) {
        addCheck("minLengthCheck", item -> item.length() >= reqLength);
        return this;
    }
}
