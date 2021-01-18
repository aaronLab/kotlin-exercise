package net.aaronlab.mvc.controller.exception

import net.aaronlab.mvc.model.http.Error
import net.aaronlab.mvc.model.http.ErrorResponse
import net.aaronlab.mvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest
import javax.validation.ConstraintViolationException
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api/exception")
@Validated
class ExceptionAPIController {

    @GetMapping("/hello")
    fun hello() {
        val list = mutableListOf<String>()
        val temp = list[0]
    }

    @GetMapping("/get")
    fun get(
        @NotBlank
        @Size(min = 2, max = 6)
        @RequestParam name: String,

        @Min(10)
        @RequestParam age: Int
    ): String {
        println(name)
        println(age)
        return "$name $age"
    }

    @PostMapping("/post")
    fun post(@Valid @RequestBody userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun methodArgumentNotValidException(
        e: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> {
        val errors = mutableListOf<Error>()

        e.bindingResult.allErrors.forEach { errorObject ->

            val error = Error().apply {
                this.field = (errorObject as FieldError).field
                this.message = errorObject.defaultMessage
                this.value = errorObject.rejectedValue
            }

            errors.add(error)
        }

        val errorResponse = ErrorResponse().apply {
            this.resultCode = "FAIL"
            this.httpStatus = HttpStatus.BAD_REQUEST.value()
            this.httpMethod = request.method
            this.message = "invalid body"
            this.path = request.requestURI.toString()
            this.timestamp = LocalDateTime.now()
            this.errors = errors
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun constraintViolationException(
        e: ConstraintViolationException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> {
        val errors = mutableListOf<Error>()

        e.constraintViolations.forEach {

            val error = Error().apply {
                this.field = it.propertyPath.last().name
                this.message = it.message
                this.value = it.invalidValue
            }

            errors.add(error)
        }

        val errorResponse = ErrorResponse().apply {
            this.resultCode = "FAIL"
            this.httpStatus = HttpStatus.BAD_REQUEST.value()
            this.httpMethod = request.method
            this.message = "bad request"
            this.path = request.requestURI.toString()
            this.timestamp = LocalDateTime.now()
            this.errors = errors
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }

    /*
    해당 컨트롤러 안에만 동작
     */
    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }

}