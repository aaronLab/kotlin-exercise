package net.aaronlab.mvc.validator

import net.aaronlab.mvc.annotation.StringFormatDateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class StringFormatDateTimeValidator : ConstraintValidator<StringFormatDateTime, String> {

    private var pattern: String? = null

    override fun initialize(constraintAnnotation: StringFormatDateTime?) {
        this.pattern = constraintAnnotation?.pattern
    }

    override fun isValid(p0: String?, p1: ConstraintValidatorContext?): Boolean {
        return try {
            LocalDateTime.parse(p0, DateTimeFormatter.ofPattern(pattern))
            true
        } catch(e: Exception) {
            false
        }
    }

}