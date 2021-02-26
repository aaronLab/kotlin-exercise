# GET

### @RequestController
- 컨트롤러를 선언

### @RequestMapping("path")
- Path를 지정

### @GetMapping(path = Array<String>)
- String 또는 Array<String> 으로 path 지정
- @RequestMapping을 사용하여 method를 지정하는 것도 가능

### @PathVariable
- 메소드 파라미터로 PathVariable을 선언하여 PathVariable로 사용 가
- {이름}을 이용해서 path variable 지정 가능
- PathVariable 파라미터 이름을 메소드 내에서 따로 사용해야할 경우 PathVariable(value = "이름") 형태로 지정하고, 
  파라미터 이름 앞에 언더스코어를 붙여준다.

### @RequestParam
- 리퀘스트 파라미터를 받을 수 있음
- 메소드 내 파라미터 이름을 동일하게 사용해야할 경우에는 PathVariable과 동일한 방식을 이용

### Object Parameter
- 반환될 값이 Object이면 JSON으로 반환됨
- 파라미터로 data class를 사용하면 됨
- 쿼리 파라미터 키 이름에 하이픈이 있는 경우 객체로 받을 수 없음
- 이럴 경우에는 RequestParam이나 Map을 사용

### Map Parameter
- @RequestParam을 사용하여 Map<String, Any> 형태로 반환이 가능
- 하이픈이 들어갔을 때도 Key 매핑 가능