package net.aaronlab.mvc.controller.put

import net.aaronlab.mvc.model.http.Result
import net.aaronlab.mvc.model.http.UserRequest
import net.aaronlab.mvc.model.http.UserResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PutAPIController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - pub method"
    }

    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {
        // User Response
        return UserResponse()
            .apply {
                // Result
                this.result = Result()
                    .apply {
                        this.resultCode = "OK"
                        this.resultMessage = "Success"
                    }
            }.apply {
                // Description
                this.description = "OK"
            }.apply {
                // User Mutable List
                val userList = mutableListOf<UserRequest>()
                userList.add(userRequest)
                userList.add(UserRequest().apply {
                    this.name = "Beth"
                    this.age = 30
                    this.email = "beth@beth.com"
                    this.address = "Toronto, ON, CA"
                    this.phoneNumber = "111-111-1111"
                })
                userList.add(UserRequest().apply {
                    this.name = "Syeda"
                    this.age = 20
                    this.email = "syeda@syeda.com"
                    this.address = "Toronto, ON, CA"
                    this.phoneNumber = "111-111-1111"
                })

                this.userRequest = userList

                println(this)
            }
    }

}