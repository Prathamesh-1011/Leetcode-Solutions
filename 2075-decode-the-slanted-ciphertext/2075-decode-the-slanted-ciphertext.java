class Solution {
    public String decodeCiphertext(String t, int rows) {
        if(rows == 1)
            return t;
        StringBuilder sb = new StringBuilder();
        int c=t.length()/rows;
        for(int j=0; j<c; j++)
        {
            int k=j;
            while(k<t.length())
            {
                sb.append(t.charAt(k));
                k+=c+1;
            }
        }
        String s = sb.toString();
        int ind=-1;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)!=' ')
                ind = i;
        }
        return s.substring(0,ind+1);
    }
}