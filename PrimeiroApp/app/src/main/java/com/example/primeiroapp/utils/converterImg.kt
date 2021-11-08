
package com.example.imc.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.util.*
import java.util.concurrent.TimeUnit

fun convertBitmapToBase64(bitmap: Bitmap) : String {
    val bitmapArray = ByteArrayOutputStream()

    bitmap.compress(
            Bitmap.CompressFormat.JPEG,
            100,
            bitmapArray)

    return Base64.encodeToString(
            bitmapArray.toByteArray(),
            Base64.DEFAULT)

}


fun convertBase64ToBitmap(base64Image: String) : Bitmap{
    val imageByte = Base64.decode(base64Image, Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(imageByte,0, imageByte.size)
}