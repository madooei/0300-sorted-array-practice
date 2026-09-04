package practice;

/** A runnable demo of Leaderboard: a jumbled sequence of scores, top-k kept, best first. */
public final class PracticeMain {

  private PracticeMain() {}

  public static void main(String[] args) {
    Leaderboard<Integer> board = new Leaderboard<>(3);
    int[] scores = {50, 70, 30, 90, 10, 80, 60};
    for (int s : scores) {
      board.add(s);
      System.out.println("after add " + s + ": " + topToString(board));
    }

    System.out.println();
    System.out.println("final board (best first): " + topToString(board));
    System.out.println("size = " + board.size() + ", capacity = " + board.capacity());

    Leaderboard<String> names = new Leaderboard<>(2);
    for (String n : new String[] {"Ada", "Linus", "Grace", "Alan"}) {
      names.add(n);
    }
    System.out.println();
    System.out.println("top 2 names (latest alphabetically): " + topToString(names));
  }

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
