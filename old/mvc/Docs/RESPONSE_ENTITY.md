# RESPONSE ENTITY

|Title|Description|
|:---|:---|
|String|일반 Text Type 응답|
|Object|자동으로 Json 변환되어 응답 상태값은 항상 200 OK|
|ResponseEntity|Body의 내용을 Object로 설정<br>상황에 따라서 HttpStatus Code 설정|
|@ResponseBody|RestController가 아닌곳(Controller)에서 Json응답을 내릴 때|