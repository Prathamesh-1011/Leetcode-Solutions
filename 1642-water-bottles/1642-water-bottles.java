class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
      int numwaterBottles=numBottles;
      while(numBottles>=numExchange){
        int exchange=numBottles/numExchange;
        numwaterBottles+=exchange;
        numBottles=exchange + (numBottles % numExchange);
      }  
      return numwaterBottles;
    }
}