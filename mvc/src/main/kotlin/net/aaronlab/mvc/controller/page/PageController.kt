package net.aaronlab.mvc.controller.page

import net.aaronlab.mvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

/*
뷰 보여줄 때...
 */
@Controller
class PageController {

    /*
    HTML 반환(resources/static/...)
    http://localhost:8080/main
     */
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    /*
    ResponseBody
    Text, Json 등 플레인 값 반환 with Controller
     */
    @ResponseBody
    @GetMapping("/test")
    fun response(): UserRequest {
        return UserRequest().apply {
            this.name = "aaron"
        }
    }

}