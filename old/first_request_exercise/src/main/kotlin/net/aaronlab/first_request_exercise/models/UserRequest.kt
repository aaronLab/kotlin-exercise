package net.aaronlab.first_request_exercise.models

import javax.validation.constraints.PositiveOrZero

data class UserRequest(
    var name: String? = null,

    @field:PositiveOrZero
    var age: Int? = null
)
