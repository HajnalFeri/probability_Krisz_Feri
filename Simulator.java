import java.util.Arrays;

public class Simulator {

    Simulation simulation;
    Logger logger;

    public Simulator(Simulation simulation, Logger logger) {

        this.simulation = simulation;
        this.logger = logger;
    }

    public Result run() {
        int[][] lottoNumbers = simulation.getLottoNumbers();
        NumbersFrequency nf = new NumbersFrequency(lottoNumbers);
        int[] bestNums = nf.getBestNums();
        int freq42 = nf.calcFreq(42);
        Statistics stats = new Statistics(freq42);
        Result result = new Result(bestNums, stats);
        logger.log("HALI:","");
        return result;
        
    }
}