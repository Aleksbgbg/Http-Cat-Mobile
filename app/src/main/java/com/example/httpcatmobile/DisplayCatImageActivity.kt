package com.example.httpcatmobile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DisplayCatImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_cat_image)

        val httpStatusCode = intent.getStringExtra(HTTP_STATUS_CODE)

        // TODO: Load cat image based on HTTP status code
    }
}