# compareTo를 자바라

1. CompareTo(Object)
   - 이 인스턴스를 지정된 Object와 비교하고 정렬 순서에서 지정된 Object보다 앞인지, 뒤인지, 동일한지 나타냄
   - public int CompareTo (object value);
   - 반환 값이 0보다 작음 : 이 인스턴스가 value앞에 오는 경우
   - 반환 값이 0 : value와 같은 경우
   - 반환 값이 0보다 큼 : value 뒤에 오는 경우, 또는 value가 null인 경우
2. CompareTo(String)
   - 이 인스턴스를 지정된 String개체와 비교하고 정렬 순서에서 앞인지 뒤인지 동일한지를 나타냄
   - public int CompareTo (String strB);
   - 0보다 작음 : 인스턴스가 strB앞에 오는 경우
   - 0 : strB와 위치가 정렬 순서에서 같음
   - 0보다 큼 : strB 다음에 오는 경우 또는 strB가 null인 경우