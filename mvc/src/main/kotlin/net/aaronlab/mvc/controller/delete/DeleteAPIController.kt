package net.aaronlab.mvc.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteAPIController {

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,
        @RequestParam age: Int
    ): String {
        val name = ""
        println(_name)
        println(age)
        return "$_name $age"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @PathVariable name: String,
        @PathVariable(value = "age") _age: Int
    ): String {
        val age = 0
        println(name)
        println(_age)
        return "$name $_age"
    }

}