package net.aaronlab.mvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated
class DeleteAPIController {

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,

        @NotNull(message = "error: no age")
        @Min(value = 20, message = "error: age should be more than 20 or 20")
        @RequestParam age: Int
    ): String {
        val name = ""
        println(_name)
        println(age)
        return "$_name $age"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @Size(min = 2, max = 5, message = "error: name size should be 2 to 5")
        @NotNull(message = "error: no name")
        @PathVariable name: String,

        @NotNull(message = "error: no age")
        @Min(value = 20, message = "error: age should be more than 20 or 20")
        @PathVariable(value = "age") _age: Int
    ): String {
        val age = 0
        println(name)
        println(_age)
        return "$name $_age"
    }

}