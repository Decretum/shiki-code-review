package complete;


/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

Examples:
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] note = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        int[] map = new int[128]; // ASCII TABLE has 128 elements, from 0 to 127
        for (char c : mag) {
            map[c]++;
        }
        for (char c : note) {
            if (--map[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
