class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        int len1 = word1.length(), len2 = word2.length();
        
        while (i < len1 || j < len2) {
            if (i < len1) {
                result.append(word1.charAt(i++));
            }
            if (j < len2) {
                result.append(word2.charAt(j++));
            }
        }
        
        return result.toString();
    }
}