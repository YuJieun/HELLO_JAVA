### Arrays.fill()

```java
int[] arr = new int[]{1,2,3,4,5};
Arrays.fill(arr,100);
/* arr은 [100,100,100,100,100]*/

int[] arr = new int[]{1,2,3,4,5};
Arrays.fill(arr,2,4,100);
/* arr은 [1,2,100,100,5] */

int[][] arr = new int[3][5];
for(int[] row: arr){
    Arrays.fill(row,10);
}
/* arr은
[10,10,10,10,10]
[10,10,10,10,10]
[10,10,10,10,10]*/
```

