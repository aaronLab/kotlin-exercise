package net.aaronlab.first.controller.post

import net.aaronlab.first.model.http.UserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }

    @PostMapping("/post-obj")
    fun postMappingObj(@RequestBody userRequest: UserRequest): UserRequest {
        return userRequest
    }

}