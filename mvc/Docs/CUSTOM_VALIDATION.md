# CUSTOM VALIDATION ANNOTATION

- 반복적으로 사용되는 커스텀 검증 값을 만들어서 사용(@AssertTrue)
- annotation class 생성
- 같은 포맷을 여러 곳에서 쓸 때 커스텀 어노테이션을 만들어서 검증 가능

### WHY?

- 유효성 검증 코드의 길이가 너무 길어진다
- 서비스 로직에 방해가 된다
- 흩어져 있는 경우 어디서 검증되었는지 찾기 힘들다
- 검증 로직이 변경되는 경우 테스트 코드 등, 전체 로직이 흔들릴 수 있다.

### spring-boot-starter-validation

|Title|Description|Notes|
|:---|:---|:---|
|@Size|문자 길이 측정|Int Type 불가|
|@NotNull|null 불가||
|@NotEmpty|null, "" 불가||
|@NotBlank|null, "", " " 불가||
|@Past|과거 날짜||
|@PastOrPresent|오늘이나 과거 날짜||
|@Future|미래날짜||
|@FutureOrPresent|오늘이거나 미래 날짜||
|@Pattern|정규식 적용||
|@Max|최댓값||
|@Min|최솟값||
|@AssertTrue / False|별도 Logic 적용||
|@Valid|해당 object validation 실행||
