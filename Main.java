import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;


public class Main {

    Logger logger;

    public static Simulation generateSimulation(int round) {
        Simulation s = new Simulation(round);
        for (int l = 0; l < round; l++) {
            int[] lottoNumber = new int[6];
            int index = 0;
            
            for (int i = 0; i < 6; i++) {
                int randomNum = (int) (Math.random() * 45 + 1); 
                for (int x = 0; x < i; x++) {
                    if (lottoNumber[x] == randomNum) {
                        randomNum = (int) (Math.random() * 45 + 1);
                        x = -1; 
                    }
                    
                }
                lottoNumber[index] = randomNum;
                index++;
            }
            s.generateData(lottoNumber);
        }
        return s;
    }

    public static int checkInput(String input,Logger logger){
        Scanner reader = new Scanner(System.in);
        int n=0;
        try{
           n = Integer.parseInt(input);
            if(n<0){
                logger.log("Error: ","Input can not be negative!");
                logger.log("Message: ","Please, enter new input!");
                String s = reader.next();
                n = Integer.parseInt(s);
                if(n<0){
                    checkInput(input, logger);
                }
                
            }
        }catch(Exception e){
            logger.log("Error: ", "Wrong input type!(Expected input is a number.)");
            logger.log("Message: ","Please, enter new input!");
            String s = reader.next();
            
            try{
                n = Integer.parseInt(s);
                if(n<0){
                    checkInput(input, logger);
                }
            }catch(Exception l){
                checkInput(input,logger);
            }
            
        }  
        return n;
    }

    public static void main(String[] args) {

        Logger logger = new Logger();
        int n = checkInput(args[0], logger);
        int round = Integer.parseInt(args[0]);
        Simulation simulation = generateSimulation(round);
        Simulator simulator = new Simulator(simulation, logger);
        Result r = simulator.run();
        int[] bestArrayAsString = r.getBestNums();
        logger.log("\n","After your rounds the 6 most frequent numbers were:\n");
        logger.log("", Arrays.toString(bestArrayAsString));
        logger.log("\n", "You should bet them if you want to loose some money on the lottery!\n"); 
    }
}