# VALIDATION

- gradle
  - `implementation("org.springframework.boot:spring-boot-starter-validation")`
- [참고](https://beanvalidation.org/2.0/spec/)
- 데이터 클래스에는 @field:Name을 사용함
- Validated: 컨트롤러 단위 검증
- Valid: 파라미터 처럼 작은 해당 단위 bean 검증
- Valid한 결과를 BindingResult 파라미터로 담을 수 있다
- @AssertTrue: 검증 과정에서 수행할 수 있게 함(기존에 없는 검증 로직 커스텀 할 때)