package vjc.com.imagecompare

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import android.widget.ImageView

class ImageInspectorView : FrameLayout {

    constructor(ctx: Context) : super(ctx){
        init()
    }

    constructor(ctx: Context, attr: AttributeSet) : this(ctx) {

    }

    var bitmap: Bitmap? = null
    set(value) {
        _imageView.setImageBitmap(field)
        _imageView.layoutParams.width = 100
        _imageView.layoutParams.height = 100
        field?.let {
            _imageView.layoutParams.width = it.width
            _imageView.layoutParams.height = it.height
        }
        _imageView.requestLayout()
    }


    private val _imageView: ImageView = ImageView(this.context)

    private fun init() {
        setBackgroundColor(Color.CYAN)
        this.addView(_imageView)
        _imageView.setBackgroundColor(Color.RED)
        this.bitmap = null

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> println("down")
        }

        return false
    }



}