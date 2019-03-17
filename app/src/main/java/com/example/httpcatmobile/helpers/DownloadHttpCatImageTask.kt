package com.example.httpcatmobile.helpers

import android.graphics.Bitmap
import android.graphics.BitmapFactory.decodeStream
import android.os.AsyncTask
import android.widget.ImageView
import java.net.URL

class DownloadHttpCatImageTask(private val httpStatusCode: String, private val image: ImageView) : AsyncTask<Void, Void, Bitmap>() {
    override fun doInBackground(vararg params: Void?): Bitmap {
        return decodeStream(URL("https://http.cat/$httpStatusCode").openStream())
    }

    override fun onPostExecute(result: Bitmap) {
        image.setImageBitmap(result)
    }
}