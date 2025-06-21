class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }

        int minDel = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            int del = 0;
            int baseFreq = freq[i];

            for (int j = 0; j < 26; j++) {
                if (freq[j] == 0 || i == j) continue;
                int compFreq = freq[j];

                if (compFreq < baseFreq) {
                    del += compFreq;
                } else if (compFreq - baseFreq > k) {
                    del += compFreq - baseFreq - k;
                }
            }

            minDel = Math.min(minDel, del);
        }

        return minDel;
    }
}
