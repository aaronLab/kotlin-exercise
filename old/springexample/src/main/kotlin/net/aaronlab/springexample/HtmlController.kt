package net.aaronlab.springexample

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class HtmlController {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("title", "HOME")
        return "index"
    }

    @GetMapping("/{formType}")
    fun htmlForm(model: Model, @PathVariable formType: String): String? {

        var response: String? = null
        if (formType.equals("signup")) {
            response = "SIGNUP"
        } else if (formType.equals("login")) {
            response = "LOGIN"
        }

        model.addAttribute("title", response)

        return response
    }

}
