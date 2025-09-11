class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> arr = new ArrayList<>(); 
        for(int i=0;i<s.length();i++)
        {
            if(isVowel(s.charAt(i)))
            {
                arr.add(s.charAt(i));
            }
        }
        char []ans = new char[arr.size()];
        for(int i=0;i<ans.length;i++)
        {
            ans[i] = arr.get(i);
        }
        Arrays.sort(ans);
        StringBuffer str = new StringBuffer(s);
        int x = 0;
        for(int i=0;i<s.length();i++)
        {
            if(isVowel(s.charAt(i)))
            {
             str.setCharAt(i,ans[x]);   
             x++;   
            }
        }
        return str.toString();
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}