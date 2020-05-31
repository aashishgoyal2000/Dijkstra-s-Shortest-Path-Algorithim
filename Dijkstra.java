public class Dijkstra {

  public static void main(String[] args) {
    int[][] graph = { { 0, 4, 0, 1, 0, 0, 0, 0, 0 }, 
                      { 4, 0, 3, 0, 7, 0, 0, 0, 0 }, 
                      { 0, 3, 0, 0, 4, 0, 0, 0, 0 }, 
                      { 1, 0, 0, 0, 3, 1, 0, 0, 0 }, 
                      { 0, 1, 4, 3, 0, 1, 5, 0, 3 }, 
                      { 0, 0, 0, 1, 1, 0, 0, 2, 4 }, 
                      { 0, 0, 0, 0, 5, 0, 0, 0, 5 }, 
                      { 0, 0, 0, 0, 0, 2, 0, 0, 3 }, 
                      { 0, 0, 0, 0, 3, 4, 5, 3, 0 } };
    Point pArray[] = new Point[graph.length];
    for (int i = 0; i < graph.length; ++i) {
      pArray[i] = new Point();
      pArray[i].makeANode(i);
    }

    Graph gp = new Graph(graph);
    PriorityQueue pq = new PriorityQueue(graph.length);

    System.out.println("Executing for Node 1");
    gp.neighbors(pq,pArray,1);
    System.out.println(pq.toString());

    while(pq.contains(8) == -1) {
        
        Point p = pq.delMax();
        System.out.println("Executing for Node " + p.node);
        gp.neighbors(pq,pArray,p.node);
        System.out.println(pq.toString());
 
    }

    System.out.println(pq.contains(8));
    System.out.println(pq.tellIndex(8));
    Point pst = pq.arr[pq.tellIndex(8)];
    while(pst != null) {
      System.out.println(pst.node);
      pst = pst.past;
    }



  }
}