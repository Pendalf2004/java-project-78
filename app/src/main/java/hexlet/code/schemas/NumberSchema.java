package hexlet.code.schemas;


public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        notNullCheck = true;
        return this;
    }

    public NumberSchema positive() {
        addCheck("isPositiveCheck", item -> item > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("isInRangeCheck", item -> (min <= item) && (max >= item));
        return this;
    }
}
