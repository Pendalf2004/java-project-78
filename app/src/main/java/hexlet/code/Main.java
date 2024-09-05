package hexlet.code;


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

    }
}
