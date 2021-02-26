package net.aaronlab.first_request_exercise.controllers.post

import net.aaronlab.first_request_exercise.models.UserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/post"])
class PostController {

    @PostMapping(path = ["/hello"])
    fun hello(): String {
        return "hello"
    }

    @PostMapping(path = ["/body"])
    fun body(@RequestBody userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

}