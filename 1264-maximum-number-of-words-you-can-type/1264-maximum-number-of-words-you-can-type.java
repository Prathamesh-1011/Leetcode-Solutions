class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> bl=new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++){
            bl.add(brokenLetters.charAt(i));
        }

        String[] words=text.split(" ");
        int c=0;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                if(bl.contains(words[i].charAt(j))){
                    c++;
                    break;
                }
            }
        }

        return words.length-c;
    }
}