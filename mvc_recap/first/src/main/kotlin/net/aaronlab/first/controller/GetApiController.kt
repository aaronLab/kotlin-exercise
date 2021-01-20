package net.aaronlab.first.controller

import net.aaronlab.first.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping("/hello")
    fun hello(): String {
        return "hello kotlin"
    }

    @GetMapping("/path-variable/{name}/{age}")
    fun pathVariable(
        @PathVariable(value = "name") name: String,
        @PathVariable(value = "age") age: Int
    ): String {
        return name + age
    }

    @GetMapping("/query-param")
    fun queryParam(
        @RequestParam(value = "name") name: String,
        @RequestParam(value = "age") age: Int
    ): String {
        return name + age
    }

    @GetMapping("/query-obj")
    fun queryParamObj(userRequest: UserRequest): UserRequest {
        return userRequest
    }

    /*
     */
    @GetMapping("/query-map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        return map
    }

}