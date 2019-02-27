package biz.laenger.android.foo.app.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import biz.laenger.android.foo.app.R
import kotlinx.android.synthetic.main.app_activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_main)
        setSupportActionBar(toolbar)
    }

}
