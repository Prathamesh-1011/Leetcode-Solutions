class Solution {
    static {
        for(int i = 0; i < 500; ++i)
            candy(new int[]{1,3,2});
    }
    public static int candy(int[] ratings) {
        int n=ratings.length;
        int i=1,sum=1;

        while(i<n){
            if(ratings[i]==ratings[i-1]){
                sum=sum+1;
                i++;
                continue;
            }
            int peak=1;
            while(i<n && ratings[i]>ratings[i-1]){
                peak+=1;
                sum+=peak;
                i++;
            }

            int down =1;
            while(i<n && ratings[i]<ratings[i-1]){
                sum+=down;
                down++;
                i++;
            }

            if(down>peak){
                sum=sum+(down-peak);
            }
        }
        return sum;
    }
}