package net.aaronlab.mvc.controller.response

import net.aaronlab.mvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/*
http://localhost:8080/api/response
 */
@RestController
@RequestMapping("/api/response")
class ResponseAPIController {

    /*
    1. GET 4xx
    http://localhost:8080/api/response?age=20
     */
    @GetMapping(path = [""])
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {

        return age?.let {
            // age not null
            if (age < 20) {
                return ResponseEntity.status(400).body("fail: should be over 20")
            }

            ResponseEntity.ok("OK")
        }?: kotlin.run {
            // age null
            return ResponseEntity.status(400).body("fail: no age")
        }
    }

    /*
    2. POST 200
     */
    @PostMapping(path = [""])
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest) // object mapper -> object -> json
    }

    /*
    3. PUT 201
     */
    @PutMapping(path = [""])
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        // No data existing -> New Data
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    /*
    4. DELETE 500
     */
    @DeleteMapping(path = ["/{id}"])
    fun deleteMapping(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }

}