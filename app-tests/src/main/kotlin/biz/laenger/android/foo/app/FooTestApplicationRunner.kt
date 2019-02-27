package biz.laenger.android.foo.app

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class FooTestApplicationRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, FooTestApplication::class.java.canonicalName, context)
    }

}
