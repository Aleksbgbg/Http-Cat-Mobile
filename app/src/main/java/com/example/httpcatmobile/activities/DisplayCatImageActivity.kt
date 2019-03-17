package com.example.httpcatmobile.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.httpcatmobile.helpers.DownloadHttpCatImageTask
import com.example.httpcatmobile.HTTP_STATUS_CODE
import com.example.httpcatmobile.R

class DisplayCatImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_cat_image)

        val httpStatusCode = intent.getStringExtra(HTTP_STATUS_CODE)
        val image = findViewById<ImageView>(R.id.imageView)

        DownloadHttpCatImageTask(httpStatusCode, image).execute()
    }
}