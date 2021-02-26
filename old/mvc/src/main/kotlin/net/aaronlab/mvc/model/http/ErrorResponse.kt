package net.aaronlab.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class ErrorResponse(
    @field:JsonProperty(value = "result_code")
    var resultCode: String? = null,

    @field:JsonProperty(value = "http_status")
    var httpStatus: Int? = null,

    @field:JsonProperty(value = "http_method")
    var httpMethod: String? = null,

    var message: String? = null,
    var path: String? = null,
    var timestamp: LocalDateTime? = null,
    var errors: MutableList<Error>? = mutableListOf()
)

data class Error(
    var field: String? = null,
    var message: String? = null,
    var value: Any? = null
)