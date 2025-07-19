class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder,(a,b)->a.length()-b.length());
        List<String> res=new ArrayList<>();
        Set<String> set=new HashSet<>();
        for(String dir:folder){
            boolean add=true;
            for(int i=2;i<=dir.length();i++){
                if(i<dir.length() && dir.charAt(i)!='/'){
                    while( i<dir.length() && dir.charAt(i)!='/' )i++;
                }
                if(!set.contains(dir.substring(0,i))){
                    continue;
                }
                else{
                    add=false;
                    break;
                }
            }
            if(add){
                set.add(dir);
                res.add(dir);
            }
        }
        return res;
    }
}