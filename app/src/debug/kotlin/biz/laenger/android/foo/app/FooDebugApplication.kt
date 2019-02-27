package biz.laenger.android.foo.app

import android.annotation.SuppressLint
import timber.log.LogcatTree
import timber.log.Timber

@SuppressLint("Registered")
class FooDebugApplication : FooApplication() {

    init {
        Timber.plant(LogcatTree())
    }

}
