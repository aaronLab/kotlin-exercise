# POST

### @RequestBody
- 파라미터 객체를 POST 바디로 받을 때 사용
- in: json -> object
- out: object -> json

### @JsonNaming
- 바디로 받을 객체의 네이밍
    - ex: `@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)`
