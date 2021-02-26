package net.aaronlab.first.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteApiController {

    @DeleteMapping("/del-mapping")
    fun delMapping(
        @RequestParam name: String,
        @RequestParam age: Int
    ): String {
        return name + age
    }

    @DeleteMapping("/del-mapping/name/{name}/age/{age}")
    fun delPath(@PathVariable name: String, @PathVariable age: String): String {
        return name + age
    }

}