class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        boolean canType = true;

        for (int i = 0; i <= text.length(); i++) {
            if (i < text.length() && text.charAt(i) != ' ') {
                if (brokenLetters.indexOf(text.charAt(i)) >= 0) {
                    canType = false;
                }
            } else {
                if (canType) {
                    count++;
                }
                canType = true;
            }
        }

        return count;


       

    }
}