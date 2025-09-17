import java.util.*;

class FoodRatings {
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, PriorityQueue<FoodEntry>> cuisineHeaps;
    
    private class FoodEntry {
        String food;
        int rating;
        
        FoodEntry(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }
    }
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineHeaps = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
            
            cuisineHeaps.computeIfAbsent(cuisines[i], k -> 
                new PriorityQueue<>((a, b) -> {
                    if (a.rating != b.rating) return b.rating - a.rating;
                    return a.food.compareTo(b.food);
                })).offer(new FoodEntry(foods[i], ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        foodToRating.put(food, newRating);
        cuisineHeaps.get(cuisine).offer(new FoodEntry(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<FoodEntry> heap = cuisineHeaps.get(cuisine);
        
        while (!heap.isEmpty()) {
            FoodEntry entry = heap.peek();
            if (foodToRating.get(entry.food) == entry.rating) {
                return entry.food;
            }
            heap.poll(); // Remove outdated entry
        }
        return "";
    }
}