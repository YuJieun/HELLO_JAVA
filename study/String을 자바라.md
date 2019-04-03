# String을 자바라

#### StringBuffer

- append라는 메소드를 이용하여 문자열을 추가해 나갈 수 있다.

- ```java
  public class Test {
      public static void main(String[] args) {
          StringBuffer sb = new StringBuffer();
          sb.append("hello");
          sb.append(" ");
          sb.append("jump to java");
          System.out.println(sb.toString());
      }
  }
  
  ```

- toString() 메소드를 이용하면 String으로 변경 가능하다.
- String은 '+' 할때마다 새로운 String객체가 생성된다.
- StringBuffer은 append할때마다 기존의 객체에 추가된다.
- StringBuffer은 String보다 속도가 느리고 메모리 사용량도 많으므로, 문자열 추가나 변경 등의 작업이 많은 경우에만 쓰도록 한다.

- ```java
  StringBuffer str = new StringBuffer("Java Oracle");
  System.out.println("원본 문자열 : " + str);
  System.out.println(str.delete(4, 8)); //4~7까지 없앤다. 0부터 시작.
  System.out.println(str.deleteCharAt(1)); //1인 a만지움
  System.out.println("deleteCharAt() 메소드 호출 후 원본 문자열 : " + str);
  
  ```

- 출력결과는 아래와 같다

- 원본 문자열 : Java Oracle

  Javacle

  Jvacle

  deleteCharAt() 메소드 호출 후 원본 문자열 : Jvacle

  

- ```java
  StringBuffer str = new StringBuffer("Java 만세!!");
  System.out.println("원본 문자열 : " + str);
  System.out.println(str.insert(4, "Script")); //4번째자리에 삽입 -> JavaScript 만세!!
  System.out.println("insert() 메소드 호출 후 원본 문자열 : " + str);
  ```

```java

```

#### StringTokenizer

- 긴 문자열을 지정한 구분자를 기준으로 슬라이싱한다.

- ```java
  public static void main(String[] args){
      String source = "100,200,300,400";
      StringTokenizer st = new StringTokenizer(source,",");
      
      while(st.hasMoreTokents()){
          System.out.println(st.nextToken());
      }
  }
  ```

#### StringBuilder

- StringBuffer와 성격이 비슷함
- StringBuffer는 멀티쓰레드환경에서 synchronized 키워드가 가능하므로 동기화가 가능. thread-safe
- StringBuilder는 동기화를 지원하지 않기 때문에 멀티쓰레드환경에서는 적합하지 않다. 
- StringBuilder는 동기화를 고려하지 않기 때문에 ***싱글쓰레드 환경******에서 StringBuffer보다*** ***빠르다***.
- 따라서 멀티쓰레드환경에서는 StringBuffer, 싱글쓰레드 또는 쓰레드를 안쓰는 환경에서는 StringBuilder 쓰는것이 적절