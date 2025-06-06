class Solution
{
    public String robotWithString(String s)
    {
        int [] m = new int[26];
        int l = s.length();

        for(int i=0; i<l; i++)
            m[s.charAt(i)-'a']++;

        Stack<Character> a = new Stack<>();
        StringBuilder b = new StringBuilder(l);
        char x;

        for(int c=0, p=0; (c = smallestRemaining(m))!=-1;)
        {
            x = (char)(c + 'a');
            
            while(!a.isEmpty() && a.peek()<=x)
                b.append(a.pop());

            while(p<s.length() && m[c]>0)
            {
                if(s.charAt(p)==x)
                    b.append(x);
                
                else
                    a.push(s.charAt(p));

                m[s.charAt(p)-'a']--;
                p++;
            }
        }

        for(int i=a.size()-1; i>=0; i--)
            b.append(a.get(i));

        return b.toString();
    }

    int smallestRemaining(int [] m)
    {
        for(int i=0; i<26; i++)
            if(m[i]>0)
                return i;

        return -1;
    }
}