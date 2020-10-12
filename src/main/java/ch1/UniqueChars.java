package ch1;

public class UniqueChars {

    /**
     * ASCII only contains 128 chars, 256 if extended
     * @param str
     * @return
     */
    boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean [] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueChars uniqueChars = new UniqueChars();
        String testStr = "asfdlsakldklf3i9a";
        System.out.println("Is unique? " + uniqueChars.isUniqueChars(testStr));

        testStr = "abcdefghijklmnopqrstuvwxyz1234567890";
        System.out.println("Is unique? " + uniqueChars.isUniqueChars(testStr));
    }

}
