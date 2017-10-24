public class Crypto {
    public static void main(String[] args) {
        String original = "Hel^l!!o Wo r ld";
        original = normalizeText(original);
        System.out.print(original);
    }

    public static String normalizeText(String str) {
        str = str.toUpperCase();
        System.out.println(str);
        str = str.replace(" ", "");
        String pattern = "(\\W)";
        str = str.replaceAll(pattern, "");
        return str;
    }
}
