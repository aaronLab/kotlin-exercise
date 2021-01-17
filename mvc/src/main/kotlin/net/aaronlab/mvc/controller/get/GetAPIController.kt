package net.aaronlab.mvc.controller.get

import net.aaronlab.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

/*
GET
http://localhost:8080/api
 */
@RestController
@RequestMapping("/api")
class GetAPIController {

    /*
    기본적인 Get
     */
    @GetMapping(path = ["/hello", "/abcd"])
    fun hello(): String {
        return "Hello Kotlin!"
    }

    /*
    예전 방식
     */
    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    /*
    http://localhost:8080/api/get-mapping/path-variable/<String>/<String>
     */
    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("${name}, $age")
        return "$name $age"
    }

    /*
    파라미터의 이름을 메소드 내에서 사용해할 때의 네이밍 예시
     */
    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age: Int): String {
        val name = "kotlin"
        println("${_name}, $age")
        return "$_name $age"
    }

    /*
    쿼리 파라미터
    메소드 내 파라미터 이름을 동일하게 사용해야할 때는 위와 동일
     */
    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam(value = "name") name: String,
        @RequestParam age: Int
    ): String {
        println("${name}, ${age}")
        return "$name $age"
    }

    /*
    쿼리를 Object 받을 때
    RestController를 선언 해두고, 파라미터가 Object이면 Json으로 반환됨
    쿼리 파라미터에 하이픈이 있는 경우는 객체로 받을 수 없음
    RequestParam을 이용
     */
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    /*
    하이픈이 들어갔을 때 키로 받아도 되고, map으로 받아도 됨
     */
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map["phone-number"]
        println(phoneNumber)
        return map
    }

}