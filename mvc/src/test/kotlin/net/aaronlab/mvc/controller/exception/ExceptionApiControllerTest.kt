package net.aaronlab.mvc.controller.exception

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import net.aaronlab.mvc.model.http.UserRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.util.LinkedMultiValueMap

@WebMvcTest
@AutoConfigureMockMvc
class ExceptionApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun helloTest() {
        mockMvc.perform(
            get("/api/exception/hello")
        ).andExpect(
            status().isOk
//            status().isBadRequest
        ).andExpect(
            content().string("hello")
        ).andDo(
            print()
        )
    }

    @Test
    fun getTest() {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name", "aaron")
        queryParams.add("age", "20")

        mockMvc.perform(
            get("/api/exception/get").queryParams(queryParams)
        ).andExpect(
            status().isOk
        ).andExpect(
            content().string("aaron 20")
        ).andDo(
            print()
        )
    }

    @Test
    fun getFailTest() {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name", "aaron")
        queryParams.add("age", "9")

        mockMvc.perform(
            get("/api/exception/get").queryParams(queryParams)
        ).andExpect(
            status().isBadRequest
        ).andExpect(
            content().contentType("application/json")
        ).andExpect(
            jsonPath("\$.result_code").value("FAIL")
        ).andExpect(
            jsonPath("\$.errors[0].field").value("age")
        ).andExpect(
            jsonPath("\$.errors[0].value").value("9")
        ).andDo(
            print()
        )
    }

    @Test
    fun postTest() {

        val userRequest = UserRequest().apply {
            this.name = "aaron"
            this.age = 10
            this.phoneNumber = "010-1234-1234"
            this.address = "Toronto"
            this.email = "aaron@aaron.aaron"
            this.createdAt = "2022-10-10 13:00:00"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest)

        println(json)

        mockMvc.perform(
            post("/api/exception/post")
                .content(json)
                .contentType("application/json")
                .accept("application/json")
        ).andExpect(
            status().isOk
        ).andExpect(
            jsonPath("\$.name").value("aaron")
        ).andExpect(
            jsonPath("\$.age").value("10")
        ).andExpect(
            jsonPath("\$.email").value("aaron@aaron.aaron")
        ).andExpect(
            jsonPath("\$.address").value("Toronto")
        ).andExpect(
            jsonPath("\$.phoneNumber").value("010-1234-1234")
        ).andExpect(
            jsonPath("\$.createdAt").value("2022-10-10 13:00:00")
        ).andDo(
            print()
        )
    }

    @Test
    fun postErrorTest() {

        val userRequest = UserRequest().apply {
            this.createdAt = "2021-11-11 10:11:11"
            this.email = "aaron@aaron.aaron"
            this.address = "Ontario"
            this.phoneNumber = "010-1111-1111"
            this.age = -1
            this.name = "aaron"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest)

        mockMvc.perform(
            post("/api/exception/post")
                .content(json)
                .contentType("application/json")
                .accept("application/json")
        ).andExpect(
            status().isBadRequest
        ).andExpect(
            jsonPath("\$.errors[0].field").value("age")
        ).andExpect(
            jsonPath("\$.errors[0].value").value("-1")
        ).andDo(
            print()
        )
    }

}