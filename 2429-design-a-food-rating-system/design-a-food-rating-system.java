class FoodRatings {

    Map<String, TreeMap<Integer, TreeSet<String>>> cmap;
    Map<String, Integer> fmap;
    Map<String, String> fcmap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cmap = new HashMap<>();
        fmap = new HashMap<>();
        fcmap = new HashMap<>();
        for(int i=0;i<foods.length;i++) {
            if(!cmap.containsKey(cuisines[i])) {
                cmap.put(cuisines[i], new TreeMap<>());
            }
            TreeMap<Integer, TreeSet<String>> tmap = cmap.get(cuisines[i]);
            if(!tmap.containsKey(ratings[i])) {
                tmap.put(ratings[i], new TreeSet<>());
            }
            tmap.get(ratings[i]).add(foods[i]);

            fmap.put(foods[i], ratings[i]);
            fcmap.put(foods[i], cuisines[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        int oldRating = fmap.get(food);
        fmap.put(food, newRating);
        TreeMap<Integer, TreeSet<String>> tmap = cmap.get(fcmap.get(food));
        tmap.get(oldRating).remove(food);
        if(tmap.get(oldRating).size() == 0) {
            tmap.remove(oldRating);
        }

        if(!tmap.containsKey(newRating)) {
            tmap.put(newRating, new TreeSet<>());
        }
        tmap.get(newRating).add(food);
    }
    
    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> tmap = cmap.get(cuisine);
        return tmap.get(tmap.lastKey()).first();
    }
}

