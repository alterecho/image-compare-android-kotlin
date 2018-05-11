package com.vjc.imagecompare.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.vjc.imagecompare.extensions.*
import com.vjc.imagecompare.model.Pointer

class ImageInspectorView : FrameLayout {

    constructor(ctx: Context) : super(ctx){
        init()
    }

    constructor(ctx: Context, attr: AttributeSet) : this(ctx) {

    }

    var bitmap: Bitmap? = null
    set(value) {
        _imageView.bitmap = field
    }




    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            val touchPoint = PointF(it.x, it.y);

            val pointer = Pointer(event.actionIndex, event.getPointerId(event.actionIndex))

            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    println("down")
                    _touchPoint_began = touchPoint
                    _touchPoint_offset = touchPoint.bySubtracting(_imageView.position)

                    _pointer1 = pointer

                    return true
                }

                MotionEvent.ACTION_POINTER_DOWN -> {
                    _pointer2 = pointer
                }

                MotionEvent.ACTION_MOVE -> {
                    if (pointer.equals(_pointer1)) {
                        _imageView.position = touchPoint.bySubtracting(_touchPoint_offset)
                    } else {

                    }

                }

                MotionEvent.ACTION_POINTER_UP -> {
                    _pointer2 = null
                }

                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    _touchPoint_offset = PointF()
                    _pointer1 = null
                }
            }
        }



        return false
    }


    private val _imageView: ImageView = ImageView(this.context)
    private var _touchPoint_began = PointF(0.0f, 0.0f)
    /** difference between where the the touch began and where _imageView position (center) */
    private var _touchPoint_offset = PointF()

    private var _pointer1: Pointer? = null
    private var _pointer2: Pointer? = null

    private fun init() {
        setBackgroundColor(Color.CYAN)
        this.addView(_imageView)
        _imageView.setBackgroundColor(Color.RED)
        this.bitmap = null

    }


}