# Issue with Android's `com.android.test` plugin

With the `com.android.test` [plugin](https://developer.android.com/studio/test#use_separate_test_modules_for_instrumented_tests), instrumented tests can reside in a separate Gradle module, isolated from the rest of the code.
Using this plugin in combination with AndroidX AppCompat, however, causes the `IllegalStateException` below upon launching an Activity.

**The crash occurs in this scenario only!** Building the same tests from the regular `androidTest` source set works just fine. Launching the app manually also works fine. All common explanations of the error below seem to not apply.

```
Caused by: java.lang.IllegalStateException: This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.
        at androidx.appcompat.widget.AppCompatDrawableManager.checkVectorDrawableSetup(AppCompatDrawableManager.java:756)
        at androidx.appcompat.widget.AppCompatDrawableManager.getDrawable(AppCompatDrawableManager.java:196)
        at androidx.appcompat.widget.TintTypedArray.getDrawableIfKnown(TintTypedArray.java:86)
        at androidx.appcompat.app.AppCompatDelegateImpl.<init>(AppCompatDelegateImpl.java:260)
        at androidx.appcompat.app.AppCompatDelegate.create(AppCompatDelegate.java:182)
        at androidx.appcompat.app.AppCompatActivity.getDelegate(AppCompatActivity.java:520)
        at androidx.appcompat.app.AppCompatActivity.onCreate(AppCompatActivity.java:71)
        at biz.laenger.android.foo.app.presentation.main.MainActivity.onCreate(MainActivity.kt:28)
        at android.app.Activity.performCreate(Activity.java:7009)
        at android.app.Activity.performCreate(Activity.java:7000)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1214)
        at androidx.test.runner.MonitoringInstrumentation.callActivityOnCreate(MonitoringInstrumentation.java:674)
        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2731)
        ... 9 more
```

## Reproduce
Reproduce the issue with this small demo project and the following commands.

Build app, androidTest, and the tests in the separate module.
```
./gradlew clean app:bundleDebug app:assembleDebugAndroidTest app-tests:assemble
```

Install the app.
```
bundletool build-apks --bundle=app/build/outputs/bundle/debug/app.aab --output=app/build/outputs/bundle/debug/app.apks
bundletool install-apks --apks=app/build/outputs/bundle/debug/app.apks
```

Install and run the tests from the `app` module. Works as expected :v:
```
adb install -r app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk
adb shell am instrument -w biz.laenger.android.foo.app.test/biz.laenger.android.foo.app.FooTestApplicationRunner
```

Install and run the tests from the `app-tests` module. Causes the error :confused:
```
adb install -r app-tests/build/outputs/apk/debug/app-tests-debug.apk
adb shell am instrument -w biz.laenger.android.foo.app.test/biz.laenger.android.foo.app.FooTestApplicationRunner
```
