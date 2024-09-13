package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<Type> {
    protected Map<String, Predicate<Type>> checks = new HashMap<>();
    protected boolean isRequired = false;

    public final void addCheck(String nameOfCheck, Predicate<Type> check) {
        checks.put(nameOfCheck, check);
    }

    public final boolean isValid(Type item) {
        if (isRequired && Objects.isNull(item)) {
            return false;
        }
        if (!isRequired && Objects.isNull(item)) {
            return true;
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
