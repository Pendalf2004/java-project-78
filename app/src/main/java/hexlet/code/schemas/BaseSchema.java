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
        return checks.values().stream()
                .allMatch(check -> check.test(item));
    }

}
