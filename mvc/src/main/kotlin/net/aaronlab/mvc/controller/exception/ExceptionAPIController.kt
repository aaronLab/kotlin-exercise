package net.aaronlab.mvc.controller.exception

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/exception")
class ExceptionAPIController {

    @GetMapping("/hello")
    fun hello() {
        val list = mutableListOf<String>()
        val temp = list[0]
    }

//    /*
//    해당 컨트롤러 안에만 동작
//     */
//    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
//    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String> {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
//    }

}