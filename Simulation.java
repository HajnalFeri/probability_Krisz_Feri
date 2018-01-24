public class Simulation {

    private int[][] lottoNumbers;

    public Simulation() {
        this.lottoNumbers = new int[0];
    }

    public Simulation(int[][] lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int[][] getLottoNumbers() {
        return lottoNumbers;
    }

    public void generateData() {
        int[] lottoNumber = new int[6];
        int randomNum;
        int index = 0;
        for (int i = 0; i < 6; i++) {
            randomNum = (int) (Math.random() * 45 + 1); 
            for (int x = 0; x < i; x++) {
                if (lottoNumber[x] == randomNum) {
                    randomNum = (int) (Math.random() * 45 + 1);
                    x = -1; 
                }
            }
            lottoNumber[index] = randomNum;
            index += 1;
        }
        addToArray(lottoNumbers, lottoNumber);
        appendToFile(lottoNumber);
    }

    public void load() {
        
    }
}