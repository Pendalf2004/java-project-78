package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public final NumberSchema required() {
        isRequired = true;
        return this;
    }

    public final NumberSchema positive() {
        addCheck("isPositiveCheck", item -> item > 0);
        return this;
    }

    public final NumberSchema range(Integer min, Integer max) {
        addCheck("isInRangeCheck", item -> (min <= item) && (max >= item));
        return this;
    }
}
