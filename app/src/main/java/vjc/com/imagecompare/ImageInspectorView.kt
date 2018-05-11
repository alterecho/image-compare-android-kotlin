package vjc.com.imagecompare

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView

class ImageInspectorView : FrameLayout {

    constructor(ctx: Context) : super(ctx){
        init()
    }

    constructor(ctx: Context, attr: AttributeSet) : this(ctx) {

    }

    fun init() {
        setBackgroundColor(Color.BLUE)
    }


    private val _imageView: ImageView = ImageView(this.context)
}