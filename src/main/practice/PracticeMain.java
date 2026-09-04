package practice;

/**
 * A small demo of the practice solution: a Top-K Leaderboard that keeps only the
 * largest elements it has been offered, in order. Scores are fed in a jumbled
 * order; the board holds on to just the top three, best-first.
 */
public final class PracticeMain {

  private PracticeMain() {
    // Entry-point holder — not instantiated.
  }

  public static void main(String[] args) {
    // Keep the top 3 scores out of everything we offer.
    Leaderboard<Integer> board = new Leaderboard<>(3);
    int[] scores = {50, 70, 30, 90, 10, 80, 60};
    for (int s : scores) {
      board.add(s);
      System.out.println("after add " + s + ": " + topToString(board));
    }

    System.out.println();
    System.out.println("final board (best first): " + topToString(board));
    System.out.println("size = " + board.size() + ", capacity = " + board.capacity());

    // A Leaderboard works for any Comparable type — here, Strings ordered
    // alphabetically, keeping the two that sort latest.
    Leaderboard<String> names = new Leaderboard<>(2);
    for (String n : new String[] {"Ada", "Linus", "Grace", "Alan"}) {
      names.add(n);
    }
    System.out.println();
    System.out.println("top 2 names (latest alphabetically): " + topToString(names));
  }

  // Reads the board top-down through get, where index 0 is the highest-ranked.
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
