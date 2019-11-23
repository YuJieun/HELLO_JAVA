# Collections.sort

```java
Collections.sort(arr,new Comparator<String>(){
  @Override
  public int compare(String s1, String s2){
    return map.get(s2).compareTo(map.get(s1));
  }
});

Collections.sort(arrs,new Comparator<music>(){
  @Override
  public int compare(music m1, music m2){
    if(m1.play>m2.play)
      return -1;
    else if(m1.play == m2.play){
      if(m1.idx<m2.idx)
        return -1;
      else
        return 1;
    }
    else
      return 1;
  }
});
```



```java

```

