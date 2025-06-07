class Solution {
    class node{
        char ch;
        int ind;
         node(char ch,int ind){
            this.ch=ch;
            this.ind=ind;
        }
    }
    public String clearStars(String s) {
       PriorityQueue<node> pq=new PriorityQueue<>(new Comparator<>(){
        public int compare(node n1,node n2){
            if(n1.ch==n2.ch){
                return n2.ind-n1.ind;
            }
            return n1.ch-n2.ch;
        }
        });
        StringBuilder sb=new StringBuilder();
        char[] arr=s.toCharArray();
        int n=s.length();
        int i=0;
        while(i<n){
            if(s.charAt(i)=='*'){
                node n1=pq.poll();
                arr[n1.ind]='*';
                arr[i]='*';
               
            }
            else{
            pq.add(new node(s.charAt(i),i));
            }
            i++;
        }
       for(int j=0;j<n;j++){
         if(arr[j]!='*'){

            sb.append(arr[j]);
         }
       }
        return sb.toString();


       
    }
}