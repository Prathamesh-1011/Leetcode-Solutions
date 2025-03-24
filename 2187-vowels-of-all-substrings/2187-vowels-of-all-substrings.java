class Solution {
    public long countVowels(String word) {
        long res = 0, sz = word.length();
        for (int i = 0; i < sz; ++i)
            if ("aeiou".indexOf(word.charAt(i)) != -1)
                res += (i + 1) * (sz - i);
        return res; 
    }
}