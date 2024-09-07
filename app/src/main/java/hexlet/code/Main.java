package hexlet.code;

import hexlet.code.schemas.BaseSchema;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        var valid = new Validator();
        var stringSchema = valid.string();
        System.out.println(stringSchema.isValid(null));
        stringSchema.required();
        System.out.println(stringSchema.isValid(null));
        stringSchema = valid.string();
        stringSchema.contains("a");
        System.out.println(stringSchema.isValid("nulal"));
        System.out.println(stringSchema.isValid("null"));

        stringSchema.minLength(2);
        System.out.println(stringSchema.isValid("a"));
        System.out.println(stringSchema.isValid("nulal"));

        var v = new Validator();

        var schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        schema.isValid(human1); // true

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        schema.isValid(human2); // false

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        schema.isValid(human3); // false

    }
}
