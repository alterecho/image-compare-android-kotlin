package com.vjc.imagecompare.model

import android.view.MotionEvent

data class Pointer constructor(val index: Int, val id: Int) {

    constructor(event: MotionEvent) : this(event.actionIndex, event.getPointerId(event.actionIndex))

    override fun equals(other: Any?): Boolean {
        (other as? Pointer)?.let {
            return  other.id == this.id
        }
        return false
    }

    override fun toString(): String = "id: $id, index: $index"
}