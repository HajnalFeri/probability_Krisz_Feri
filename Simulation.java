import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Simulation {

    private int[][] playedLotteryNumbers;

    public void generateData(int[] winNumbers) {
        int[][] tempArray = load("winNumList.csv");
        playedLotteryNumbers = new int[tempArray.length + 1][6];
        for (int i = 0; i < tempArray.length; i++) {
            playedLotteryNumbers[i] = tempArray[i];
        }
        playedLotteryNumbers[playedLotteryNumbers.length - 1] = winNumbers;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("winNumList.csv"));
            for (int[] playedLotteryNumber : playedLotteryNumbers) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < playedLotteryNumber.length; i++) {
                    int num = playedLotteryNumber[i];
                    sb.append(num);
                    if (i < playedLotteryNumber.length - 1) {
                        sb.append(";");
                    }
                }
                sb.append("\n");
                bw.write(sb.toString());
            }
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int lineCounter(String csvPath) {
        int counter = 0;
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(csvPath))) {
            while ((line = reader.readLine()) != null) {
                counter++;
            }
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return counter;

    }

    public int[][] load(String csvPath) {
        int numOfLines = lineCounter(csvPath);
        String[][] lotteryNumbers = new String[numOfLines][];
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line = "";
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lotteryNumbers[lineNumber] = line.split(";");
                lineNumber++;
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        int[][] lo = str2DToInt2D(lotteryNumbers);
        return lo;
        
    }

    private int[][] str2DToInt2D(String[][] x) {
        int[][] r = new int[x.length][];
        for (int i = 0; i < x.length; i++) {
            String[] s = x[i];
            r[i] = str1DToInt1D(s);
        }
        return r;
    }

    private int[] str1DToInt1D(String[] x) {
        int[] res = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            res[i] = Integer.parseInt(x[i]);
        }
        return res;
    }

    public Simulation() {
        this.playedLotteryNumbers = new int[0][];
    }

    public Simulation(int[][] playedLotteryNumbers) {
        this.playedLotteryNumbers = playedLotteryNumbers;
    }

    public int[][] getLottoNumbers() {
        return playedLotteryNumbers;
    }
}