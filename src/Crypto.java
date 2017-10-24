public class Crypto {
    public static void main(String[] args) {
        String original = "aHel^l!!o Wo r ld";
        original = normalizeText(original);
        System.out.println(original);
        int key = -1;
        original = caesarify(original, key);
        System.out.println(original);
        original = groupify(original, 5);
        System.out.println(original);
    }

    public static String normalizeText(String str) {
        str = str.toUpperCase();
        System.out.println(str);
        str = str.replace(" ", "");
        String pattern = "(\\W)";
        str = str.replaceAll(pattern, "");
        return str;
    }

    public static String caesarify(String str, int key) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            int j = (int) str.charAt(i);
            int k = j + key;
            if ((k - 65) > 25) {
                k = ((k - 65 ) % 26) + 65;
            } else if (k < 65) {
                k = 91 - (65 - k);
            }
            res += (char)k;
        }
        return res;
    }

    public static String groupify(String str, int n) {
        if (str.length() % n > 0) {
            int j = n - (str.length() % n);
            for (int l = 0; l < j; l++) {
                str += "x";
            }
            System.out.println(str);
        }
        String res = "";
        for (int i = 0; i < str.length(); i+= n) {

            res += str.substring(i, i + n);
            res += " ";
        }
        return res;
    }

}
