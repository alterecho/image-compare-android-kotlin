package vjc.com.imagecompare

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PointF
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import vjc.com.imagecompare.ImageView

fun PointF.byAdding(point: PointF): PointF = PointF(this.x + point.x, this.y + point.y)
fun PointF.bySubtracting(point: PointF): PointF = PointF(this.x - point.x, this.y - point.y)

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

            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    println("down")
                    _touchPoint_began = touchPoint
                    _touchPoint_offset = touchPoint.bySubtracting(_imageView.position)
                    return true
                }

                MotionEvent.ACTION_POINTER_DOWN -> {

                }

                MotionEvent.ACTION_MOVE -> {
                    _imageView.position = touchPoint.bySubtracting(_touchPoint_offset)
                }

                MotionEvent.ACTION_POINTER_UP -> {

                }

                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    _touchPoint_offset = PointF()
                }
            }
        }



        return false
    }


    private val _imageView: ImageView = vjc.com.imagecompare.ImageView(this.context)
    private var _touchPoint_began = PointF(0.0f, 0.0f)
    /** difference between where the the touch began and where _imageView position (center) */
    private var _touchPoint_offset = PointF()

    private fun init() {
        setBackgroundColor(Color.CYAN)
        this.addView(_imageView)
        _imageView.setBackgroundColor(Color.RED)
        this.bitmap = null

    }


}