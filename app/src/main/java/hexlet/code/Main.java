package hexlet.code;


public class Main {
    public static void main(String[] args) {

        var val = new Validator();
        var sc = val.string();
        sc.minLength(56);
        sc.minLength(3);

        System.out.println(sc.isValid("ffff"));
    }
}
