package net.aaronlab.first_request_exercise.controllers.get

import net.aaronlab.first_request_exercise.models.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api/get"])
class GetController {
    /*
    기본 GET
     */
    @GetMapping(path = ["/hello"])
    fun hello(): String {
        return "hello"
    }

    @GetMapping(path = ["/path-variables/{name}"])
    fun pathVariables(@PathVariable name: String): String {
        return name
    }

    @GetMapping(path = ["/path-variables2/{name}"])
    fun pathVariables2(@PathVariable(value = "name") _name: String): String {
        val name = "aaron"
        return _name
    }

    @GetMapping(path = ["/request-param"])
    fun requestParam(@RequestParam name: String, @RequestParam(value = "age") _age: Int): String {
        val age = 20
        return name + age
    }

    /*
    하이픈 불가
     */
    @GetMapping(path = ["/request-param/object"])
    fun requestParamWithObj(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping(path = ["/request-param/map"])
    fun requestParamWithMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map["phone-number"]
        println(phoneNumber)
        return map
    }

    /*
    ResponseEntity with String
     */
    @GetMapping("/response/string")
    fun responseString(@RequestParam name: String): ResponseEntity<String> {
        return ResponseEntity.ok("string")
    }

    /*
    ResponseEntity with Object
     */
    @GetMapping("/response/object")
    fun responseString(
        @RequestParam name: String,
        @RequestParam age: Int
    ): ResponseEntity<UserRequest> {
        val userRequest = UserRequest()
        userRequest.apply {
            this.name = name
            this.age = age
        }
        return ResponseEntity.ok(userRequest)
    }

}