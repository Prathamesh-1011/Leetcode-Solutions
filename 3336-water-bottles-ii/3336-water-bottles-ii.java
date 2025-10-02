class Solution {
    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int currentlyFull = numBottles;
        int currentlyEmpty = 0;
        int totalBottlesDrunk = 0;

        while (currentlyFull != 0 || currentlyEmpty >= numExchange && currentlyEmpty != 0) {
            // drink all full bottles
            if (currentlyFull > 0) {
                currentlyEmpty += currentlyFull;
                totalBottlesDrunk += currentlyFull;
                currentlyFull = 0;
            }

            // to exchange bottles
            while (currentlyEmpty >= numExchange) {
                currentlyEmpty -= numExchange;
                currentlyFull++;
                numExchange++;
            }
        }

        return totalBottlesDrunk;
    }
}