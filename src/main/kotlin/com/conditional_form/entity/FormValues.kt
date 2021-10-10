package com.conditional_form.entity

data class FormValues(
    val courseType: String,
    val levelOfAdvancement: String,
    val yourSkills: Array<String>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FormValues

        if (courseType != other.courseType) return false
        if (levelOfAdvancement != other.levelOfAdvancement) return false
        if (!yourSkills.contentEquals(other.yourSkills)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = courseType.hashCode()
        result = 31 * result + levelOfAdvancement.hashCode()
        result = 31 * result + yourSkills.contentHashCode()
        return result
    }
}
