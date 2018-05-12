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
import kotlin.math.atan2

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
            val p = PointF(it.x, it.y);
            var p2 = PointF()
            var angle = 0.0f
            val pointer2 = _pointer2
            if (pointer2 != null) {
                p2 = pointer2.point(event)
                angle = atan2(p2.y - _imageView.position.y, p2.x - _imageView.position.x)
            }

            val pointer = Pointer(it)

            when (it.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    println("down")
                    _touchPoint_down = p
                    _touchPoint_offset = p.bySubtracting(_imageView.position)

                    _pointer1 = pointer

                    return true
                }

                MotionEvent.ACTION_POINTER_DOWN -> {
                    _pointer2 = pointer
                    _startAngle_imageView = _imageView.rotation
                    _startAngle = angle

                    return true
                }

                MotionEvent.ACTION_MOVE -> {
                    if (pointer.id == pointer.id) {
                        _imageView.position = p.bySubtracting(_touchPoint_offset)
                    } else {

                    }

                    if (pointer2 != null) {
                        _imageView.rotation = _startAngle_imageView + Math.toDegrees((angle - _startAngle).toDouble()).toFloat();
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
    private var _touchPoint_down = PointF(0.0f, 0.0f)
    /** difference between where the the touch began and where _imageView position (center) */
    private var _touchPoint_offset = PointF()

    /** touch identifier for first and second touch (to differentiate movement and rotation) */
    private var _pointer1: Pointer? = null
    private var _pointer2: Pointer? = null

    /** the angle w.r.t _imageView position (center), when the rotation starts */
    private var _startAngle = 0.0f

    /** the angle of the _imageView when thr rotation starts */
    private var _startAngle_imageView = 0.0f

    private fun init() {
        setBackgroundColor(Color.CYAN)
        this.addView(_imageView)
        _imageView.setBackgroundColor(Color.RED)
        this.bitmap = null

    }


}