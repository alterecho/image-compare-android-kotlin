package vjc.com.imagecompare

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import vjc.com.imagecompare.ImageView
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


    private val _imageView: ImageView = vjc.com.imagecompare.ImageView(this.context)

    private fun init() {
        setBackgroundColor(Color.CYAN)
        this.addView(_imageView)
        _imageView.setBackgroundColor(Color.RED)
        this.bitmap = null

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            val touchPoint = PointF(it.x, it.y);
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    println("down")
                    return true
                }

                MotionEvent.ACTION_POINTER_DOWN -> {

                }

                MotionEvent.ACTION_MOVE -> {
                    _imageView.position = touchPoint
                }

                MotionEvent.ACTION_POINTER_UP -> {

                }

                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {

                }
            }
        }



        return false
    }



}