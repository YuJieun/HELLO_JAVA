## int, Integer를 자바라

#### int

- 자료형을 의미
- 산술 연산이 가능
- null로 초기화 불가능. (0으로 초기화 가능)

#### Integer

- Wrapper클래스
- Unboxing 하지 않으면 산술 연산 불가능하지만 null값 처리할 수 있다
- DB에 null을 넣고 싶을 때 사용
- 하지만 Integer는 값 일치 연산 불가 Integer a, Integer b  --> a==b (X)