package complete;
/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */

public class BinaryAdd {
    public static String addBinary1(String a, String b) {
        long ia = 0;
        long ib = 0;
        int length_a = a.length();
        int length_b = b.length();
        for (int i = length_a - 1; i >= 0; i--) {
            ia += Integer.parseInt(String.valueOf(a.charAt(i))) * Math.pow(2, length_a - 1 - i);

        }
        for (int i = length_b - 1; i >= 0; i--) {
            ib += Integer.parseInt(String.valueOf(b.charAt(i))) * Math.pow(2, length_b - 1 - i);

        }
        long sum = ia + ib;
        System.out.println("ia: " + ia+ "\nib: " + ib + "\nsum: " + sum);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(sum % 2);
            sum /= 2;
        } while (sum != 0);
        return sb.reverse().toString();
    }

    public static String addBinary2(String a, String b) {
        int j = a.length() - 1;
        int k = b.length() - 1;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (j >= 0 || k >= 0) {
            if (j >= 0) sum += a.charAt(j--) - '0';
            if (k >= 0) sum += b.charAt(k--) - '0';
            sb.append(sum % 2);
            sum /= 2;
        }
        if (sum != 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("addBinary1 result:\n" + addBinary1("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));

        System.out.println("\naddBinary2 result:\n" + addBinary2("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
