package net.aaronlab.first.controller.put

import net.aaronlab.first.model.http.Result
import net.aaronlab.first.model.http.UserRequest
import net.aaronlab.first.model.http.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @PutMapping("/put-obj")
    fun putObj(@RequestBody userRequest: UserRequest): UserResponse {
        return UserResponse().apply {
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "SUCCESS"
            }
        }.apply {
            this.description = "description"
        }.apply {
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "aa"
                this.age = 10
                this.email = "aa@aa.aa"
                this.address = "bbbb"
                this.phoneNumber = "01011111111"
            })
            this.userRequest = userList
        }
    }

}