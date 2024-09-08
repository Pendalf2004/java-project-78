package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<Type> {
    protected Map<String, Predicate<Type>> checks = new HashMap<>();
    protected boolean notNullCheck = false;

    public void addCheck(String nameOfCheck, Predicate<Type> check) {
        checks.put(nameOfCheck, check);
    }

    public boolean isValid(Type item) {
        if (notNullCheck && Objects.isNull(item)) {
            return false;
        }
        if (Objects.isNull(item) && !checks.isEmpty()) {
            return false;
        }
        if (item instanceof Map && mapNotValidated(item)) {
            return false;
        }
        return checks.values().stream().
                allMatch(check -> check.test(item));
    }

    private boolean mapNotValidated(Type item) {
        if (((MapSchema) this).isShaped && item instanceof Map) {
            for (var key : ((MapSchema) this).storedValidationMap.keySet()) {
                var schema = ((MapSchema) this).get(key);
                var valueToCheck = ((Map<?, ?>) item).get(key);
                if (!schema.isValid(valueToCheck)) {
                    return true;
                }
            }
        }
        return false;
    }

}
