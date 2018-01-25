public class Result {
    
    int[] bestNums;
    Statistics statistics;
    
    public Result(int[] bestNums, Statistics statistics) {
        this.bestNums = bestNums;
        this.statistics = statistics;
    }

    public int[] getBestNums() {
        return bestNums;
    }
 }