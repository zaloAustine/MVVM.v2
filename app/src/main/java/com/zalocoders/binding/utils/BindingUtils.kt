package com.zalocoders.binding.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.zalocoders.binding.data.model.UserResponseItem

//set user title
@BindingAdapter("userTitle")
fun TextView.setTitle(item: UserResponseItem) {
    text = item.title
}
//set user body
@BindingAdapter("userBody")
fun TextView.setBody(item: UserResponseItem){
    text = item.body.substring(0, item.body.length.coerceAtMost(10))
}
