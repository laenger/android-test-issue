package biz.laenger.android.foo.app

import android.annotation.SuppressLint
import android.app.Application
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import timber.log.Timber
import timber.log.verbose

@SuppressLint("Registered")
@OpenForTesting
class FooApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.verbose { "installed modules: ${SplitInstallManagerFactory.create(this).installedModules}" }
    }

}
