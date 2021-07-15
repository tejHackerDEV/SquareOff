package com.samba.squareoff.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.samba.squareoff.R

@BindingAdapter("imageUrl", "isPortrait")
fun loadImage(view: ImageView, url: String?, isPortrait: Boolean) {
    if (url.isNullOrEmpty()) {
        if (isPortrait) {
            Glide.with(view)
                .load("https://upload.wikimedia.org/wikipedia/commons/d/d1/Image_not_available.png")
                .circleCrop()
                .into(view)
        } else {
            Glide.with(view)
                .load("https://upload.wikimedia.org/wikipedia/commons/d/d1/Image_not_available.png")
                .centerCrop()
                .into(view)
        }
    } else {
        if (isPortrait) {
            Glide.with(view)
                .load(url)
                .circleCrop()
                .into(view)
        } else {
            Glide.with(view)
                .load(url)
                .centerCrop()
                .into(view)
        }
    }
}

@BindingAdapter("slug")
fun setSlugTxt(view: TextView, txt: String) {
    view.text = txt.substring(0, txt.lastIndexOf("-"))
}

@BindingAdapter("year")
fun setYearTxt(view: TextView, txt: String) {
    view.text = view.resources.getString(R.string.year, txt.substring(txt.lastIndexOf("-") + 1))
}

@BindingAdapter("dashes")
fun setDashesTxt(view: TextView, txt: String) {
    view.text = view.resources.getString(R.string.dashes, txt.split("-").size - 1)
}