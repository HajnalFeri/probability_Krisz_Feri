import java.util.Arrays;

class NumbersFrequency {

    int[] lottoNumbFreq = new int[45];
    int[] bestNums = new int[6];
    int[][] lottoNumbers;
    
    public NumbersFrequency(int[][] lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        calcLottoNumbFreq();
        calcBestNums();
    }

    public int[] getBestNums() {
        return bestNums;
    }
    
    public void calcLottoNumbFreq() {
        for (int i = 0; i < lottoNumbers.length; i++) {
            for (int j = 0; j < lottoNumbers[i].length; j++) {
                int theNumber = lottoNumbers[i][j];
                lottoNumbFreq[theNumber - 1]++;
            }
        }
    }
    
    public void calcBestNums() {
        int bestIndex = 0;
        int biggerNum = 0;
        int index = 0;
        System.out.println(Arrays.toString(lottoNumbFreq));
        for (int i = 0; i < 6; i++) {
            for (int x = 0; x < lottoNumbFreq.length; x++) {
                if (lottoNumbFreq[x] > biggerNum) {
                    biggerNum = lottoNumbFreq[x];
                    bestIndex = x;
                }
                
                bestNums[i] = bestIndex + 1;
                
            }
            lottoNumbFreq[bestIndex] = 0;
            biggerNum = 0;
        }
    }

    public int calcFreq(int num) {
        return 10;
    }
    
}