package hexlet.code.schemas;

import java.lang.reflect.Type;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    protected boolean isShaped = false;
    protected Map<String, BaseSchema<Type>> storedValidationMap;

    public final MapSchema required() {
        isRequired = true;
        return this;
    }
    public final MapSchema sizeof(int reqSize) {
        this.addCheck("reqSize", item -> item.size() >= reqSize);
        return this;
    }
    public final MapSchema shape(Map validationMap) {
        isShaped = true;
        storedValidationMap = validationMap;
        return this;
    }

    protected final BaseSchema get(String key) {
        return this.storedValidationMap.get(key);
    }
}
