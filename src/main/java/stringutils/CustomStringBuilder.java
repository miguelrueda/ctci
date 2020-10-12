package stringutils;

import java.util.Arrays;

public class CustomStringBuilder {

    private char[] _characters = new char[100];
    private int _length = 0;

    public CustomStringBuilder() {}

    public CustomStringBuilder append(char c) {
        if (_length == _characters.length) {
            System.out.println("Doubling size");
            char [] newChars;
            newChars = Arrays.copyOf(_characters, 2 * _length);
            _characters = newChars;
        }
        _characters[_length] = c;
        _length++;
        return this;
    }

    public CustomStringBuilder append(String str) {
        if (_length == _characters.length) {
            char [] newChars;
            newChars = Arrays.copyOf(_characters, 2 * _length);
            _characters = newChars;
        }
        char [] charArray = str.toCharArray();
        for (char c: charArray) {
            _characters[_length] = c;
            _length++;
        }
        return this;
    }

    @Override
    public String toString() {
        return new String(_characters);
    }

    public static void main(String[] args) {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        customStringBuilder.append('a');
        customStringBuilder.append('b');
        customStringBuilder.append('c');
        customStringBuilder.append('d');
        customStringBuilder.append('e');
        customStringBuilder.append('f');

        System.out.println(customStringBuilder.toString());

        customStringBuilder.append("Test String Example");
        System.out.println(customStringBuilder.toString());
    }
}
