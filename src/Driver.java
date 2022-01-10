import java.util.Scanner;

public class Driver {
    private static Scanner SCAN = new Scanner (System.in);
    public static void main(String[] args) {
        System.out.println("\n\t\tWelcome to today's class! \nToday we will be checking if a bishop can reach a " +
                "certain \nspot on the board in the given amount of moves.\nKeep in mind the chessboard goes" +
                "from a1 to h8 (8x8).\n\n");
        String start = enterStart();
        String end = enterEnd();
        int moves = enterMoves();
        Bishop bishop = new Bishop(start, end, moves);
        System.out.println("\nThe bishop's starting position is " + bishop.getStart() + ".");
        System.out.println("The bishop's ending position is " + bishop.getEnd() + ".");
        System.out.println("The maximum amount of moves for the bishop to move is " + bishop.getMoves() + ".");
        System.out.println("Can the bishop reach it?\n");
        if (bishop.solve()) {
            System.out.println("True: Congratulations!");
        } else {
            System.out.println("False: Try another input.");
        }
    }

    public static void again(int method) {
        System.out.println("Incorrect input. Try again");
        switch (method) {
            case 1: enterStart();
            case 2: enterEnd();
            case 3: enterMoves();
        }
    }

    public static String enterStart() {
        System.out.print("Enter the starting position of the bishop: ");
        String result = SCAN.nextLine().toLowerCase();
        if (result.length() != 2) {
            again(1);
        } else {
            char[] array = result.toCharArray();
            if (!Character.isLetter(array[0]) || !Character.isDigit(array[1])) {
                again(1);
            } else {
                if (array[0] < 97) {
                    again(1);
                }
                if ( array[0] > 104) {
                    again(1);
                }
                if (array[1] < 49) {
                    again(1);
                }
                if (array[1] > 56) {
                    again(1);
                }
            }
        }
        return result;
    }

    public static String enterEnd() {
        System.out.print("Enter the ending position of the bishop: ");
        String result = SCAN.nextLine().toLowerCase();
        if (result.length() != 2) {
            again(2);
        } else {
            char[] array = result.toCharArray();
            if (!Character.isLetter(array[0]) || !Character.isDigit(array[1])) {
                again(2);
            } else {
                if (array[0] < 97) {
                    again(2);
                }
                if ( array[0] > 104) {
                    again(2);
                }
                if (array[1] < 49) {
                    again(2);
                }
                if (array[1] > 56) {
                    again(2);
                }
            }
        }
        return result;
    }

    public static int enterMoves() {
        System.out.print("Enter the amount of moves for the bishop: ");
        String temp = SCAN.nextLine();
        int result = 0;
        if (temp.isEmpty()) {
            again(3);
        } else {
            try {
                result = Integer.parseInt(temp);
            } catch (Exception e) {
                again(3);
            }
            if (result < 0) {
                again(3);
            }
        }
        return result;
    }
}
