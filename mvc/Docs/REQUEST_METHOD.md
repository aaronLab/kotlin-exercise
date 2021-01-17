# REQUEST METHOD

### GET

|Title|Description|Notes|
|:---|:---|:---|
|@RestController|Rest API 설정|
|@RequestMapping|리소스를 설정(method로 구분가능)|
|@GetMapping|Get Resource 설정|
|@RequestParam|URL Query Param Parsing|
|@PathVariable|URL Path Variable Parsing|
|Object|Query Param Object로 Parsing|

### POST

|Title|Description|Notes|
|:---|:---|:---|
|@RestController|Rest API 설정||
|@RequestMapping|리소스를 설정(method로 구분가능)||
|@PostMapping|Post Resource 설정||
|@RequestBody|Request Body 부분 Parsing||
|@PathVariable|URL Path Variable Parsing|잘 사용하지 않음|
|@JsonProperty|Json Naming||
|@JsonNaming|Class Json Naming||

### PUT

|Title|Description|Notes|
|:---|:---|:---|
|@RestController|Rest API 설정||
|@RequestMapping|리소스를 설정(method로 구분가능)||
|@PutMapping|Put Resource 설정||
|@RequestBody|Request Body 부분 Parsing||
|@PathVariable|URL Path Variable Parsing|잘 사용하지 않음|

### DELETE

|Title|Description|Notes|
|:---|:---|:---|
|@RestController|Rest API 설정||
|@RequestMapping|리소스를 설정(method로 구분가능)||
|@DeleteMapping|Delete Resource 설정||
|@RequestParam|URL Query Param Parsing|
|@PathVariable|URL Path Variable Parsing|잘 사용하지 않음|
|Object|Query Param Object로 Parsing|