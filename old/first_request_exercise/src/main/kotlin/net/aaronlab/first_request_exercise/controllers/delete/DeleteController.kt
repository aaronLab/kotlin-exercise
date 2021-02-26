package net.aaronlab.first_request_exercise.controllers.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping(path = ["/api/delete"])
@Validated
class DeleteController {

    @DeleteMapping(path = ["/param"])
    fun param(
        @RequestParam(value = "name") _name: String,

        @NotNull
        @Min(value = 20, message = "error: age should be over than 20 or 20")
        @RequestParam age: Int
    ): String {
        val name = ""
        return _name + age
    }

    @DeleteMapping("/path/name/{name}/age/{age}")
    fun path(
        @Size(min = 2, max = 5, message = "error: name size should be 2-5")
        @NotNull(message = "error: name is required")
        @PathVariable name: String,

        @NotNull(message = "error: age is required")
        @Min(value = 20, message = "error: age should be 20 or more than 20")
        @PathVariable(value = "age") _age: Int
    ): String {
        return name + _age
    }

}