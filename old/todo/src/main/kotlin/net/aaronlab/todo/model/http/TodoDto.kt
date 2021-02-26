package net.aaronlab.todo.model.http

import net.aaronlab.todo.annotation.StringFormatDateTime
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank

data class TodoDto(
    var index: Int? = null,

    @field:NotBlank
    var title: String? = null,

    var description: String? = null,

    @field:NotBlank
    @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss")
    var schedule: String? = null,

    var createdAt: LocalDateTime? = null,

    var updatedAt: LocalDateTime? = null
)