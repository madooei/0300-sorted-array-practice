package practice;

/**
 * A fixed-capacity leaderboard that keeps only the k largest elements it has
 * been offered, in sorted order, with get(0) as the highest-ranked element.
 *
 * @param <T> the element type, which must be comparable to itself.
 */
public class Leaderboard<T extends Comparable<T>> {

  private T[] arr;       // elements stay sorted ascending in [0, size)
  private int size;      // how many elements are currently on the board
  private final int k;   // the most elements the board will ever hold

  // Same cast rationale as SortedArray: a Comparable[] viewed as T[], because T
  // is bounded by Comparable and we cannot create an array of a type parameter.
  // We allocate k + 1 slots so add can insert before trimming back to k.
  @SuppressWarnings({"unchecked", "rawtypes"})
  public Leaderboard(int k) {
    if (k <= 0) {
      throw new IllegalArgumentException("capacity must be positive");
    }
    this.k = k;
    arr = (T[]) new Comparable[k + 1];
    size = 0;
  }

  // Offer value to the board. A full board only accepts a value that beats its
  // current smallest; anything that can't make the cut is rejected up front, so
  // we never shift for a value that would just fall off again. When a full board
  // does accept a value, the smallest element drops off to keep size at k.
  public void add(T value) {
    if (size == k && value.compareTo(arr[0]) <= 0) {
      return;                    // can't beat the lowest score — doesn't make the cut
    }
    int i = insertionPoint(value);
    for (int j = size; j > i; j--) {
      arr[j] = arr[j - 1];       // shift larger elements one slot right
    }
    arr[i] = value;
    size++;
    if (size > k) {              // we overshot capacity — the smallest falls off
      dropSmallest();
    }
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return arr[size - 1 - index];  // index 0 is the highest, stored at the top
  }

  public int size() {
    return size;
  }

  public int capacity() {
    return k;
  }

  // Returns where value sits, or, if absent, where it would have to go to keep
  // the array sorted. The same binary search SortedArray uses to place a value.
  // Pre: arr is sorted in [0, size), which add maintains.
  private int insertionPoint(T value) {
    int low = 0;
    int high = size - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      int cmp = arr[mid].compareTo(value);
      if (cmp == 0) {
        return mid;
      } else if (cmp < 0) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  // Remove the smallest element (index 0) by shifting the rest one slot left.
  private void dropSmallest() {
    for (int j = 0; j < size - 1; j++) {
      arr[j] = arr[j + 1];
    }
    size--;
    arr[size] = null;
  }
}
