/*
Your chess teacher wants to know if a bishop can reach a certain spot on the board in the given amount of moves.
Given a starting square start, ending square end and the maximum number of moves allowed n. Return true if the ending
square can be reached from the starting square within the given amount of moves. Keep in mind the chessboard goes
from a1 to h8 (8x8).

Examples:
bishop("a1", "b4", 2) ➞ true
bishop("a1", "b5", 5) ➞ false
bishop("f1", "f1", 0) ➞ true

Notes:
Chessboard is always empty (only the bishop is there).
Bishop can move in any direction diagonally.
If the starting and ending square are the same, return true (even if the move is 0).
Square names will always be lowercase and valid.
 */
public class Bishop {
    private String start;
    private String end;
    private int moves;

    public Bishop (String start, String end, int moves) {
        this.start = start;
        this.end = end;
        this.moves = moves;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getMoves() {
        return moves;
    }

    public Boolean solve() {
        if (start.equals(end)) {
            return true;
        }
        boolean result = false;
        int x_current = start.toCharArray()[0];
        int y_current = start.toCharArray()[1];
        int x_end = end.toCharArray()[0];
        int y_end = end.toCharArray()[1];
        int current_moves = 0;

        while (x_current != x_end || y_current != y_end) {
            if (x_current < x_end) {
                x_current++;
                if (y_current < y_end) {
                    y_current++;
                } else{
                    y_current--;
                }
            } else {
                x_current--;
                if (y_current < y_end) {
                    y_current++;
                } else{
                    y_current--;
                }
            }
            current_moves++;
            if (current_moves > moves) {
                break;
            }
        }
        if (current_moves <= moves) {
            result = true;
        }
        return result;
    }
}
