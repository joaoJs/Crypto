public class Crypto {
    public static void main(String[] args) {
        String original = "aHel^l!!o Wo r ld";
        int key = -2;
        int n = 5;
        original = encryptString(original, key, n);
        original = ungroupify(original);
        decryptString(original, key);
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

    public static String encryptString(String original, int key, int n) {
        original = normalizeText(original);
        System.out.println(original);
        original = caesarify(original, key);
        System.out.println(original);
        original = groupify(original, n);
        System.out.println(original);

        return original;
    }

    public static String ungroupify(String str) {
        str = str.replace(" ", "");
        str = str.replace("x", "");
        System.out.println(str);
        return str;
    }

    public static String decryptString(String str, int key) {
        int newKey = key * -1;

        String res = "";
        for (int i = 0; i < str.length(); i++) {
            int j = (int) str.charAt(i);
            int k = j + newKey;
            if ((k - 65) > 25) {
                k = ((k - 65 ) % 26) + 65;
            } else if (k < 65) {
                k = 91 - (65 - k);
            }
            res += (char)k;
        }
        System.out.println(res);
        return res;
    }

}
