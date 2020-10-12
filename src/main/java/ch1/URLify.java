package ch1;

public class URLify {

    public void replaceSpaces(char [] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') spaceCount++;
        }
        // Create a temp array just to increase original size
        char [] temp = str;
        int newSize = trueLength + spaceCount * 2;
        str = new char[newSize];
        index = newSize;
        if (trueLength < str.length) str[trueLength] = '\0'; // End array
        for (i = trueLength - 1; i >= 0 ; i--) {
            if (temp[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = temp[i];
                index--;
            }
        }
        System.out.println(new String (str));
    }

    public static void main(String[] args) {
        URLify urLify = new URLify();
        String str = "Mr John Smith   ";
        urLify.replaceSpaces(str.toCharArray(), str.trim().length());
    }
}
