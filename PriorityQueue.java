public class PriorityQueue {
  public Point[] arr;
  public int N = -1;

  PriorityQueue(int capacity) {
    arr = new Point[capacity];
  }

  public void insert(Point past1, Point queue_element, int distanceTravelled) {
    int b = contains(queue_element.node);
    if (b == -1) {
      queue_element.alter(distanceTravelled, past1);
      insert(queue_element);
    } 
    else if (b > distanceTravelled) {
      chgPrioirity(queue_element.node, distanceTravelled);
    }
    sort();
  }

  private void sort() {
    for (int i = 0; i <= N; i++) {
      for (int j = i + 1; j <= N; j++) {
        if (arr[i].compareTo(arr[j]) < 0) {
          exch(i,j);
        }
      }
    }
  }

  public int contains(int queue_element) {
    for (int i = 0; i < size(); ++i) {
      if (arr[i].node == queue_element) {
        return arr[i].distanceTravelled;
      }
    }
    return -1;
  }

  public int tellIndex(int queue_element) {
    for (int i = 0; i < size(); ++i) {
      if (arr[i].node == queue_element) {
        return i;
      }
    }
    return -1;
  }

  public void insert(Point v) {
    arr[++N] = v;
  }

  public void chgPrioirity(int queue_element, int priority) {
    for (int i = 0; i < size(); ++i) {
      if (arr[i].node == queue_element) {
        arr[i].distanceTravelled = priority;
        break;
      }
    }
  }

  public int size() {
    return N+1;
  }

  public Point delMax() {
    int large = 0;
    for (int i = 0; i < N; i++) {
      if (arr[large].compareTo(arr[i]) < 0) {
        large = i;
      }
    }
    System.out.println(arr[large].toString());
    exch(large, N);
    Point temp = arr[N--];
    return temp;
  }

  private void exch(int a, int b) {
    Point temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public Point max() {
    int large = 0;
    for (int i = 0; i < N; i++) {
      if (arr[large].compareTo(arr[i]) < 0) {
        large = i;
      }
    }
    return arr[large];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public String toString() {
    String s = "";

    for (int i = 0; i < size(); ++i) {
      s += arr[i] + "\n";
    }
    return s;
  }

}