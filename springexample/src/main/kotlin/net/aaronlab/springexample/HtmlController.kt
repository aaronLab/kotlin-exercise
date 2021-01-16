package net.aaronlab.springexample

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HtmlController {

    @RequestMapping("/")
    fun index(): String {
        return "index"
    }

}