package vjc.com.imagecompare

import android.app.Activity
import android.os.Bundle

class CompareActivity constructor() : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_compare);
    }
}