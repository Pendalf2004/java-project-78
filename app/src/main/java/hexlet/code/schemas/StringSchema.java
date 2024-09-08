package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema contains(String substring) {
        addCheck("containsSubStrCheck", item -> item.contains(substring));
        return this;
    }

    public StringSchema required() {
        notNullCheck = true;
        addCheck("isRequerdCheck", item -> !item.isEmpty());
        return this;
    }

    public StringSchema minLength(int reqLength) {
        addCheck("minLengthCheck", item -> item.length() >= reqLength);
        return this;
    }
}
