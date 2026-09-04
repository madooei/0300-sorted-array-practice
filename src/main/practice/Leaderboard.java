package practice;

/**
 * A fixed-capacity leaderboard that keeps only the k largest elements it has
 * been offered, in sorted order, with get(0) as the highest-ranked element.
 *
 * @param <T> the element type, which must be comparable to itself.
 */
public class Leaderboard<T extends Comparable<T>> {

  private T[] arr;       // sorted descending in [0, size)
  private int size;
  private final int k;

  // k + 1 slots: add briefly holds k + 1 elements before trimming back to k.
  @SuppressWarnings("unchecked")
  public Leaderboard(int k) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public void add(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public int size() {
    return size;
  }

  public int capacity() {
    return k;
  }

  // Same as SortedArray.insertionPoint, mirrored for descending order.
  private int insertionPoint(T value) {
    int low = 0;
    int high = size - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int cmp = arr[mid].compareTo(value);
      if (cmp == 0) {
        return mid;
      } else if (cmp > 0) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  // The smallest score sits at the last used index, so dropping it needs no shift.
  private void dropSmallest() {
    size--;
    arr[size] = null;
  }
}
