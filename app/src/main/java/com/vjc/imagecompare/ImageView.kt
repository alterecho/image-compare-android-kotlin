package com.vjc.imagecompare

import android.content.Context
import android.graphics.Bitmap
import android.graphics.PointF
import android.util.Size
import android.widget.ImageView

class ImageView constructor(ctx: Context) : ImageView(ctx) {

    public var bitmap: Bitmap? = null

        set(value){
            field = value
            this.setImageBitmap(field)
            this.layoutParams.width = 100
            this.layoutParams.height = 100
            field?.let {
                this.layoutParams.width = it.width
                this.layoutParams.height = it.height
            }
            this.requestLayout()
        }

    var position = PointF(0.0f, 0.0f)
        get() = PointF(this.x + width * 0.5f, this.y + height * 0.5f)
        set(value) {
            field = value
            val size = Size(width, height)

            this.x = field.x - size.width * 0.5f
            this.y = field.y - size.height * 0.5f
        }


}