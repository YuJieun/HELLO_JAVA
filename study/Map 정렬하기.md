# Map 정렬하기

1. Key에 의한 정렬

   - TreeMap을 사용한다.

   - TreeMap은 중복 허용하지 않고, Key값을 기준으로 정렬을 해준다.

     ```java
     HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
     map.put(1,1);
     map.put(2,2);
     
     TreeMap<Integer,Integer> treemap = new TreeMap<Integer,Integer>(map);
     Iterator<Integer> iter_key = treemap.keySet().iterator();
     
     while(iter_key.hasNext()){
         Integer key = iter_key.next();
         System.out.println(key + "," + treemap.get(key));
     }
     ```

     

2. Value에 의한 정렬

   - comparator 을 직접 구현하여 정렬한다.

     ```java
     HashMap <String,Integer> map = new HashMap<String,Integer>();
     map.put("a",1);
     map.put("b",10);
     map.put("c",8);
     map.put("d",12);
     
     System.out.println("sort전");
     Iterator iterator = map.keySet().iterator();
     while(iterator.hasNext()){
         String temp = (String)iterator.next();
         System.out.println(temp + "=" +map.get(temp));
     }
     
     Iterator it = sortByValue(map).iterator();
     System.out.println("sort후");
     while(it.hasNext()){
         String temp = (String)it.next();
         System.out.println(temp + "=" +map.get(temp));
     }
     
     
     
     //별도의 함수 구현하기
     public static List sortByValue(Map map){
         List<String> list = new ArrayList();
         list.addAll(map.keySet());
         
         Collections.sort(list,new Comparator(){
             public int compare(Object o1, Object o2){
                 Object v1 = map.get(o1);
                 Object v2 = map.get(o2);
                 
                 return((Comparable)v2).compareTo(v1);
             }
         });
         Collections.reverse(list); //주석시 오름차순
         return list;
     }
     ```

     