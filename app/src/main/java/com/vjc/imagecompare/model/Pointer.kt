package com.vjc.imagecompare.model

data class Pointer constructor(val index: Int, val id: Int) {
    override fun equals(other: Any?): Boolean {
        (other as? Pointer)?.let {
            return  other.id == this.id
        }
        return false
    }
}