package demo;

import java.util.Arrays;
import practice.Leaderboard;

/** A demo of Leaderboard on the sequence of scores the notes trace. */
public final class LeaderboardDemo {

  private LeaderboardDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    Leaderboard<Integer> board = new Leaderboard<>(3);
    int[] scores = {50, 70, 30, 90, 10, 80};
    System.out.println("k = 3, scores: " + Arrays.toString(scores));

    // Expect [50], [70, 50], [70, 50, 30], [90, 70, 50], [90, 70, 50], [90, 80, 70].
    for (int score : scores) {
      board.add(score);
      System.out.println("after add " + score + ": " + topToString(board));
    }

    // Expect 90, the best score.
    System.out.println("get(0): " + board.get(0));

    // Expect size 3 and capacity 3.
    System.out.println("size: " + board.size() + ", capacity: " + board.capacity());
  }

  // Builds "[a, b, c]" for a Leaderboard, best first, through its public operations.
  private static <T extends Comparable<T>> String topToString(Leaderboard<T> board) {
    StringBuilder str = new StringBuilder();
    str.append("[");
    for (int i = 0; i < board.size(); i++) {
      str.append(board.get(i));
      if (i < board.size() - 1) {
        str.append(", ");
      }
    }
    str.append("]");
    return str.toString();
  }
}
