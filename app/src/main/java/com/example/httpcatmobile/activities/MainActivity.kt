package com.example.httpcatmobile.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import com.example.httpcatmobile.HTTP_STATUS_CODE
import com.example.httpcatmobile.HttpStatusCodes
import com.example.httpcatmobile.R
import com.example.httpcatmobile.helpers.DownloadHttpCatImageTask

class MainActivity : AppCompatActivity() {
    private var currentImageIndex = 0

    private var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.imageView)

        loadImage(0)
    }

    fun loadPrevious(view: View) {
        loadImage(-1)
    }

    fun loadNext(view: View) {
        loadImage(+1)
    }

    fun exit(view: View) {
        val exitIntent = Intent(Intent.ACTION_MAIN)

        exitIntent.addCategory(Intent.CATEGORY_HOME)

        startActivity(exitIntent)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val displayCatImageIntent = Intent(this, DisplayCatImageActivity::class.java).apply {
                putExtra(HTTP_STATUS_CODE, HttpStatusCodes[currentImageIndex])
            }

            startActivity(displayCatImageIntent)

            return true
        }

        return false
    }

    private fun loadImage(offset: Int) {
        val newIndex = currentImageIndex + offset

        if (0 > newIndex || newIndex >= HttpStatusCodes.size) {
            return
        }

        currentImageIndex = newIndex

        DownloadHttpCatImageTask(HttpStatusCodes[currentImageIndex], image!!).execute()
    }
}