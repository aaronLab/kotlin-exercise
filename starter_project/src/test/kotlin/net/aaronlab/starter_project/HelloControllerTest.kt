package net.aaronlab.starter_project

import net.aaronlab.starter_project.web.HelloController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(HelloController::class)
class HelloControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun hello() {
        val hello = "hello"

        mvc.perform(
            MockMvcRequestBuilders.get("/hello"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(hello))
    }

}