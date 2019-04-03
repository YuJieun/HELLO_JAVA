# Java를 자바라

### final

- final 제어자는 '변경할 수 없다'라는 의미로 사용
- 변수를 선언과 동시에 초기화하며 이후에 값을 수정할 수 없음
- 오직 get만 가능함

- ```java
  public class Test{
      public static void main(String[] args){
          final int count = 10;
          count = 15; //여기서 에러가 난다
      }
  }
  ```

- 상수에서 final 은 무조건 static과 같이 사용된다.

- final 메소드는 오버라이딩이 불가

- final 클래스는 상속 불가, subclass 만들 수 없다.

- ```java
  final class Car { 
      // 이 클래스는 상속을 통해 서브 클래스를 생성할 수 없음.
      final int VAR;   // 이 필드는 상수화되어 값을 변경할 수 없음.
      final void brake() {      // 이 메소드는 오버라이딩을 통해 재정의할 수 없음.
          final double MAX_NUM = 10.2; // 이 지역 변수는 상수화되어 값을 변경할 수 없음.
      }
  
  }
  ```

  

### static

- java에서 static은 '공통적인'이라는 의미로 사용된다.
- 클래스의 모든 객체가 공유할 수 있다.
- staic 제어자를 변수에 사용하면, 해당 변수를 ***클래스 변수***로 만들어준다.



### Interface

- 다른 클래스를 작성할 때 기본이 되는 틀을 제공한다.

- 다른 클래스 사이의 중간 매개 역할도 담당하다.

- ```java
  interface I{
      public void z();
  }
   
  class A implements I{
      public void z(){}
  }
  ```

-  A클래스는 반드시 public void z() 메소드를 반드시 포함해야 한다.

- ```java
  interface Animal { public abstract void cry(); }
  
  class Cat implements Animal {
      public void cry() {
          System.out.println("냐옹냐옹!");
      }
  }
  
  class Dog implements Animal {
      public void cry() {
          System.out.println("멍멍!");
      }
  }
  
  public class Polymorphism03 {
      public static void main(String[] args) {
          Cat c = new Cat();
          Dog d = new Dog();
  
          c.cry();
          d.cry();
      }
  }
  ```

  