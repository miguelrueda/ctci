package ch5;

public class Utils {

    public static String printBinary(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int v = n % 2;
            sb.append(v);
            n /= 2;
        }
        sb = sb.reverse();
        System.out.println(sb);
        return sb.toString();
    }
}
