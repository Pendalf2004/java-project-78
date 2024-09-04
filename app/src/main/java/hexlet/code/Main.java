package hexlet.code;


public class Main {
    public static void main(String[] args) {

        var val = new Validator();
        var sc = val.string();
        System.out.println(sc.isValid(""));
        sc.contains("b");
        System.out.println(sc.isValid("laa"));

    }
}
