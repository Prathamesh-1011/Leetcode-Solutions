class Solution {
    public boolean isValid(String word) {
        // 1. Check minimum length
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        // Define a set for quick vowel checking
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (char c : word.toCharArray()) {
            // 2. Check for allowed characters (digits and English letters)
            if (!Character.isLetterOrDigit(c)) {
                return false; // Contains invalid characters
            }

            // Check if it's a letter (to determine vowel/consonant)
            if (Character.isLetter(c)) {
                char lowerC = Character.toLowerCase(c);
                if (vowels.contains(lowerC)) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        // 3. Check for at least one vowel and one consonant
        return hasVowel && hasConsonant;
    }
}