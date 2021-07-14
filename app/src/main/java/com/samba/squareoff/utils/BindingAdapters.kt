package com.samba.squareoff.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.samba.squareoff.R
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (url.isNullOrEmpty()) {
        Glide.with(view)
            .load("https://upload.wikimedia.org/wikipedia/commons/d/d1/Image_not_available.png")
            .circleCrop()
            .into(view)
    } else {
        Glide.with(view)
            .load(url)
            .circleCrop()
            .into(view)
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