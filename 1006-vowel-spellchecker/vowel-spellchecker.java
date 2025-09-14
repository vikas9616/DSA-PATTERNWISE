class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);

            String masked = changeVowelToStar(lower);
            vowelInsensitive.putIfAbsent(masked, word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exactWords.contains(query)) {
                result[i] = query;  // exact match
            } else {
                
                String lower = query.toLowerCase();

                if (caseInsensitive.containsKey(lower)) {
                    result[i] = caseInsensitive.get(lower);  // case-insensitive match
                } else {
                    String masked = changeVowelToStar(lower);
                    if (vowelInsensitive.containsKey(masked)) {
                        result[i] = vowelInsensitive.get(masked);  // vowel error match
                    } else {
                        result[i] = "";  // no match
                    }
                }
            }
        }

        return result;
    }

    private String changeVowelToStar(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');  // replace vowels
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}