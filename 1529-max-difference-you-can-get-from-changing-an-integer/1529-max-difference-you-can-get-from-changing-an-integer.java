class Solution {
    public int maxDiff(int num) {
        String number=""+num;
        if(number.length()==1) return 8;
        char ch=number.charAt(0);
        // char th='9';
        for(int i=0;i<number.length();i++)
        {
            if(number.charAt(i)!='9'){
                ch=number.charAt(i);
                
                break;
            }
        }
        int max=Integer.parseInt(number.replace(ch,'9'));
        number=""+num;
        char th='1';
        for(int i=0;i<number.length();i++)
        {
            if(number.charAt(i)!='1' && number.charAt(i)!='0'  ){
                ch=number.charAt(i);
                if(i!=0)th='0';
                break;
            }
        }
        //System.out.println(ch);
         int min=Integer.parseInt(number.replace(ch,th));
       // System.out.println(max+" "+min);
        return max-min;
        
    }
}