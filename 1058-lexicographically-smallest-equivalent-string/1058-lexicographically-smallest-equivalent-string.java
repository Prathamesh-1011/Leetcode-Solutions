class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n=s1.length(), parent[] = new int[26];
        for(int i=0; i<26; ++i) parent[i] = i;
        for(int i=0; i<n; ++i) {
            int val1=s1.charAt(i)-'a', val2=s2.charAt(i)-'a';
            int val1par = find(parent, val1), val2par = find(parent, val2);
            int minval = Math.min(Math.min(val1par, val2par), Math.min(val1, val2));
            parent[val1] = parent[val2] = parent[val1par] = parent[val2par] = minval;
        }
        for(int i=0; i<26; ++i) find(parent, i);
        n=baseStr.length();
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<n; ++i) sb.append((char)(parent[baseStr.charAt(i)-'a']+'a'));
        return sb.toString();
    }

    private int find(int[] map, int idx) {
        if(map[idx] == idx) return idx;
        return map[idx] = find(map, map[idx]);
    }
}