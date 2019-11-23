# HashMap메소드 정리해보기



모든 함수 뒤에는 () 가 생략되어 있습니다

.get / .put (.add아니다)

.clear : 모든 객체 제거하기

.containsKey : 해당 키가 포함되어 있는지 알려줌

.containsValue : 해당 value가 포함되어 있는지 알려줌

------

.entrySet : key-value값을 set에 저장하여 반환해줌

Set set = map.entrySet();

[A=1,B=2,C=3]

------

. keySet() : 모든 키가 저장된 set 반환

[A,B,C]

------

.remove : 해당 키 지정된 값 제거

.size : map사이즈 반환