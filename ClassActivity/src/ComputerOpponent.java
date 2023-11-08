/**
 * This class prints and gives you the computer's move in Rock, Paper, Scissors.
 */
public class ComputerOpponent {

    private static boolean TESTING_MODE = false;
    private static int cycler = 0;

    public static String getMove() {
        if (TESTING_MODE) {
            switch (cycler++ % 3) {
                case 0:
                    System.out.print("The computer chose rock");
                    return "rock";
                case 1:
                    System.out.print("The computer chose paper");
                    return "paper";
                default: // (case 2)
                    System.out.print("The computer chose scissors");
                    return "scissors";
            }
        }

        else {
            switch ((int) (Math.random() * 3)) {
                case 0:
                    System.out.print("The computer chose rock");                
                    return "rock";
                case 1:
                    System.out.print("The computer chose paper");
                    return "paper";
                default: // (case 2)
                    System.out.print("The computer chose scissors");
                    return "scissors";
            }
        }
    }


}
