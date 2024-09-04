package hexlet.code;


public class Main {
    public static void main(String[] args) {

        var val = new Validator();
        var sc = val.string();
        System.out.println(sc.required().isValid("df"));
        System.out.println(sc.contains("c").isValid("lcaa"));

    }
}
