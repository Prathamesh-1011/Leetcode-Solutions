class Solution {

    public int findClosest(int x, int y, int z) {
        return Math.floorMod(Integer.compare(Math.abs(y - z), Math.abs(x - z)), 3);
    }

}