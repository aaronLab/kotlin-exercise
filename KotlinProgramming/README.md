# 기본 패키지 활용하기

### 코틀린 기본 패키지
|패키지 이름|설명|
|:---:|:---:|
|kotlin.*|Any, Int, Double 등 핵심 함수와 자료형|
|kotlin.text.*|문자와 관련된 api|
|kotlin.sequences.*|컬렉션 자료형의 하나로 반복이 허용되는 개체를 열거|
|kotlin.ranges.*|if문이나 for문에서 사용할 범위 관련 요소|
|kotlin.io.*|입출력 관련 api|
|kotlin.collections.*|list, set, map 등의 컬렉션|
|kotlin.annotation.*|annotation 관련 api|

### 변수

- Immutable: val
- Mutable: var
- 자료형 추론 사용 가능(선언시 null 값으로 선언하지 않을 시)
    ```kotlin
    val username: String = "Aaron"
    val username = "Aaron"
    ```
- 변수 이름 규칙
    - 숫자 시작 불가
    - 예약어 사용 불가
    - Camel Notation 사용 추천
    
### 자료형

- 정수 자료형
    - Long, Int, Short, Byte
- 부호가 없는 정수 자료형
    - ULong, UInt, UShort, UByte
- 자릿값 구분
    - underscore 사용
- 실수 자료형
    - Double, Float