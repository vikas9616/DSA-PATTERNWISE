class MovieRentingSystem {
    private TreeSet<int[]>[] movies;
    private Map<Pair<Integer, Integer>, Integer> prices;
    private TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        movies = new TreeSet[10001];
        prices = new HashMap<Pair<Integer, Integer>, Integer>();
        rented = new TreeSet<int[]>(
            Comparator.comparingInt((int[] a) -> a[0]).thenComparing((int[] a) -> a[1]).thenComparing((int[] a) -> a[2])
        );

        for (int[] e : entries) {
            if (movies[e[1]] == null) {
                movies[e[1]] = new TreeSet<int[]>(
                    Comparator.comparingInt((int[] a) -> a[0]).thenComparing((int[] a) -> a[1])
                );
            }
            movies[e[1]].add(new int[] {e[2], e[0]});
            prices.put(new Pair<Integer, Integer>(e[1], e[0]), e[2]);
        }        
    }
    
    public List<Integer> search(int movie) {
        if (movies[movie] == null) {
            return Collections.emptyList();
        }
        List<Integer> retVal = new LinkedList<Integer>();
        int i = 0;
        for (int[] e : movies[movie]) {
            if (i == 5) {
                break;
            }
            i++;
            retVal.add(e[1]);
        }
        return retVal;
    }
    
    public void rent(int shop, int movie) {
        int price = prices.get(new Pair<Integer, Integer>(movie, shop));        
        movies[movie].remove(new int[] {price, shop});
        rented.add(new int[] {price, shop, movie});       
    }
    
    public void drop(int shop, int movie) {
        int price = prices.get(new Pair<Integer, Integer>(movie, shop));        
        movies[movie].add(new int[] {price, shop});
        rented.remove(new int[] {price, shop, movie});       
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> retVal = new LinkedList<List<Integer>>();
        int i = 0;
        for (int[] e : rented) {
            if (i == 5) {
                break;
            }
            i++;
            retVal.add(List.of(e[1], e[2]));
        }
        return retVal;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */