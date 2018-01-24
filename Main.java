public class Main {

}

public static Simulation generateSimulation(int round) {
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
    Simulation simulation = new Simulation(lottoNumbers);


    Simulation s = new Simulation();
    if (round == 0) {
        s.load();
    } else {
        for (int i = 0; i < round; i++) {
            s.generateData();
        }
    }
    return s;


    return simulation;
}

public static void main(String[] args) {
    
    int round = Integer.parseInt(args[0]);
    Simulation simulation = generateSimulation(round);

}