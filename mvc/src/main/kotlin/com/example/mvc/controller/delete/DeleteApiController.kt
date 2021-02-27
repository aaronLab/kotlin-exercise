package com.example.mvc.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteApiController {

    @DeleteMapping("/delete-mapping")
    fun deleteMapping(
        @RequestParam name: String,
        @RequestParam age: Int
    ): String {
        return "$name $age"
    }

    @DeleteMapping("/delete-mapping/{name}/{age}")
    fun deleteMappingPath(
        @PathVariable name: String,
        @PathVariable age: Int
    ): String {
        return "$name $age"
    }

}