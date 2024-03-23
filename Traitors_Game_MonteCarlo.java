import java.util.*;

// Here is how it works.
// Because the faithful vote randomly (including votes against themselves) -
// and the traitors always vote against a single faithful -
// the faithful will always lose once the traitors make-up over half of the remaining players.
// And the closer we get to the traitors making-up half of the remaining players, the more likely the faithful are to lose.

// The percentage chance of the traitors winning based on their frequency in a game, can be converted to a ratio, traitors : faithful -
// which can be used to calculate the chance of the traitors winning at any point - of any game - with any number of players remaining.

public class Main {

    public static void main (String [] args) {
        for(int i = 1; i <= 21; i++) {
            int players = 22;
            System.out.println("with " + i + " traitors, there is a " + simulation(i, players - i, 100000) + " % chance of winning");
        }
    }

    public static double simulation(int traitors, int faithful, int simulations) {
        Random rand = new Random();
        int tratorCount = 0;
        for(int i = 0; i < simulations; i++) {
            int traitorsLeft = traitors;
            int faithfulLeft = faithful;
            while(traitorsLeft > 0 && faithfulLeft > 0 && (faithfulLeft + traitorsLeft > 2)) {
                if(rand.nextDouble() < (double) faithfulLeft / (traitorsLeft + faithfulLeft)) {
                    faithfulLeft--;
                } else {
                    traitorsLeft--;
                }
                if(faithfulLeft > 0) {
                    faithfulLeft--;
                }
                // Correcting the win condition logic
                if (traitorsLeft > 0 && (faithfulLeft == 0 || traitorsLeft + faithfulLeft == 2)) {
                    tratorCount++;
                }

            }
        }
        return ((double) tratorCount / simulations * 100);
    }
}
