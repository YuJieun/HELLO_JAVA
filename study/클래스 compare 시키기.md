## 클래스 compare 시키기

```java
class Point implements Comparable<Point>{
   int to, weight;
   
   Point(int to, int weight){
      this.to = to;
      this.weight = weight;
   }
   
   @Override
   public int compareTo(Point p) {
	   return this.weight - p.weight;
   }
}
```

