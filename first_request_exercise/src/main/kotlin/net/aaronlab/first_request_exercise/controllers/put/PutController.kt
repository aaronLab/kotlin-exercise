package net.aaronlab.first_request_exercise.controllers.put

import net.aaronlab.first_request_exercise.models.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.StringBuilder
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/api/put"])
class PutController {

    @PutMapping("/hello")
    fun hello(): String {
        return "hello"
    }

    @PutMapping("/body")
    fun body(@Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult): ResponseEntity<String> {

        if (bindingResult.hasErrors()) {
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append("$field: $message")
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg.toString())
        }

        return ResponseEntity.ok("OK")
    }

}