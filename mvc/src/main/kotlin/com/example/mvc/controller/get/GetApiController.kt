package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping(path = ["/hello", "/abcd"])
    fun hello(): String {
        return "Hello, Kotlin + Spring Boot"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "Request Mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(
        @PathVariable(value = "name") _name: String,
        @PathVariable age: Int
    ): String {
        val name = "another name"

        println(name)

        return "Hello, ${_name.capitalize()}($age)!"
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam name: String,
        @RequestParam(name = "age") age: Int
    ): String {
        return "${name.capitalize()} $age"
    }

    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        return userRequest
    }

    /**
     * 하이픈...
     */
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {

        val phoneNumber = map["phone-number"].toString()

        println(phoneNumber)

        return map
    }

}