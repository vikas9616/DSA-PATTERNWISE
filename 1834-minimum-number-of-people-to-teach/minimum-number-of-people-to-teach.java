class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;

        Map<Integer, Set<Integer>> personLanguages = new HashMap<>();
        for (int i = 0; i < m; i++) {
            personLanguages.put(i + 1, new HashSet<>());
            for (int lang : languages[i]) {
                personLanguages.get(i + 1).add(lang);
            }
        }

        Set<Integer> candidates = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0];
            int v = f[1];
            Set<Integer> langU = personLanguages.get(u);
            Set<Integer> langV = personLanguages.get(v);

            boolean canCommunicate = false;
            for (int lang : langU) {
                if (langV.contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }

            if (!canCommunicate) {
                candidates.add(u);
                candidates.add(v);
            }
        }

        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int teachCount = 0;
            for (int person : candidates) {
                if (!personLanguages.get(person).contains(lang)) {
                    teachCount++;
                }
            }
            minTeach = Math.min(minTeach, teachCount);
        }

        return minTeach;
    }
}