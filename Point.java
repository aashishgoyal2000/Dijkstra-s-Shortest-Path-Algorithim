
import java.lang.Comparable;

public class Point implements Comparable<Point> {
  public int node;
  public Point past=null;
  public int distanceTravelled = 0;

  @Override
  public int compareTo(Point a) {
    if (a.distanceTravelled > this.distanceTravelled) {
      return 1;
    }
    else if (a.distanceTravelled < this.distanceTravelled) {
      return -1;
    }
    return 0;
  }
  public void makeANode(int node){
    this.node = node;

    // this.past = ps;
  }
  public String toString(){
    int n =past.node;
    return (node+" "+ distanceTravelled + " " + n );
  }
  public void alter(int distanceTravelled, Point ps) {
    this.distanceTravelled = distanceTravelled;
    this.past = ps;
  }
}