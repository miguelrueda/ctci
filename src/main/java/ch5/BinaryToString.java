package ch5;

public class BinaryToString {

    String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
            // Setting a limit on length: 32 characters
            if (binary.length() >= 32) {
                return "ERROR";
            }

            double r = num * 2;
            System.out.println(r);

            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        BinaryToString binaryToString = new BinaryToString();
        System.out.println(binaryToString.printBinary(0.8));
    }

}
