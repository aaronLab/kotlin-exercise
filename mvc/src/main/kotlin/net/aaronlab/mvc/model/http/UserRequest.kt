package net.aaronlab.mvc.model.http

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

data class UserRequest(

    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name: String? = null,

    @field:PositiveOrZero // 0 이상
    var age: Int? = null,

    @field:Email // 이메일 양식 검증
    var email: String? = null,

    @field:NotBlank
    var address: String? = null,

    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$") // 정규식
    var phoneNumber: String? = null,

    var createdAt: String? = null // yyyy-MM-dd HH:mm:ss    ex) 2021-01-01 13:00:00
) {

    @AssertTrue(message = "error: should be formatted like this: yyyy-MM-dd HH:mm:ss") // 검증 과정에서 실행될 수 있게
    private fun isValidCreatedAt(): Boolean {
        return try {
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        } catch(e: Exception) {
            false
        }
    }

}