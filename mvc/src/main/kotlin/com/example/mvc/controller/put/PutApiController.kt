package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
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

    @PutMapping("/put-mapping/object")
    fun putMappingObj(@RequestBody userRequest: UserRequest): UserResponse {
        // 0. Response
        return UserResponse().apply {
            // 1. Result
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "Success"
            }
        }.apply {
            // 2. Description
            this.description = "Description"
        }.apply {
            // 3. User Mutable List
            val userList = mutableListOf<UserRequest>()

            userList.add(userRequest)

            userList.add(UserRequest().apply {
                this.name = "Test"
                this.age = 20
                this.email = "test@test.test"
                this.address = "test"
                this.phoneNumber = "010-1111-1111"
            })

            userList.add(UserRequest().apply {
                this.name = "Test2"
                this.age = 20
                this.email = "test2@test.test"
                this.address = "test2"
                this.phoneNumber = "010-1111-1111"
            })

            this.userRequest = userList

        }

    }

}