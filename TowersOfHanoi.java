/*
* This program uses a method to find where disks should be placed.
*
* @author  Cristiano Sellitto
* @version 1.0
* @since   2024-04-24
*/

import java.util.Scanner;

/**
* This is the program.
*/
final class TowersOfHanoi {
    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this is ever called
    *
    * @throws IllegalStateException if this is ever called
    *
    */
    private TowersOfHanoi() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Calculates where disks should be placed.
     *
     * @param numberOfDisks the number of disks
     * @param startPeg the starting number of pegs
     * @param endPeg the ending number of pegs
     */
    static void hanoi(int numberOfDisks, int startPeg, int endPeg) {
        final int numberPegs = 6;
        final String toString = " to ";

        if (numberOfDisks != 1) {
            hanoi(numberOfDisks - 1, startPeg, numberPegs - startPeg - endPeg);
            System.out.println(
                "Move disk " + numberOfDisks + " from peg "
                + startPeg + toString + endPeg
            );
            hanoi(numberOfDisks - 1, numberPegs - startPeg - endPeg, endPeg);
        } else {
            System.out.println(
                "Move disk 1 from peg "
                + startPeg + toString + endPeg
            );
        }
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        // Peg constants
        final int startPeg = 1;
        final int endPeg = 3;

        // Scanners
        final Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter number of disks: ");
            final int selectedDisks = Integer.parseInt(input.nextLine());
            if (selectedDisks < 0) {
                input.close();
                throw new NumberFormatException();
            }
            hanoi(selectedDisks, startPeg, endPeg);
        } catch (NumberFormatException nfe) {
            System.out.println("This is not a valid number.");
        }

        // Close scanners
        input.close();

        // Show the program as done
        System.out.println("\nDone.");
    }
}
