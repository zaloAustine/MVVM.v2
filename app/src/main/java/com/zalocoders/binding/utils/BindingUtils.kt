package com.zalocoders.binding.utils

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.marginLeft
import androidx.databinding.BindingAdapter
import com.zalocoders.binding.R
import com.zalocoders.binding.data.model.UserResponseItem

//set user title
@BindingAdapter("userTitle")
fun TextView.setTitle(item: UserResponseItem) {
    text = item.title
    when(item.id){
        1 -> setTextColor(ResourcesCompat.getColor(resources, R.color.white,null))
        else -> setTextColor(ResourcesCompat.getColor(resources, R.color.black,null))
    }
}
//set user body
@BindingAdapter("userBody")
fun TextView.setBody(item: UserResponseItem){
    text = item.body.substring(0, item.body.length.coerceAtMost(10))
    when(item.id){
        1 -> setTextColor(ResourcesCompat.getColor(resources, R.color.white,null))
        else -> setTextColor(ResourcesCompat.getColor(resources, R.color.black,null))
    }
}

@BindingAdapter("cardBackColor")
fun CardView.setCardColor(item:UserResponseItem){
    when(item.id){
        1 -> setBackgroundColor(ResourcesCompat.getColor(resources, R.color.black,null))
        else -> setBackgroundColor(ResourcesCompat.getColor(resources, R.color.white,null))
    }
}
