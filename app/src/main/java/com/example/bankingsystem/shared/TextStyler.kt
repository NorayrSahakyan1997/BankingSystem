package com.example.bankingsystem.shared
import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import com.example.bankingsystem.R

object TextStyler {
      fun changeColorOfLettersInText(context:Context,content:String,end:Int):Spannable{
         val spannable: Spannable = SpannableString(content)
         val length = content.length
         val start = length - end
         val color = ContextCompat.getColor(context, R.color.logInButtonColor)
         val spanType = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
         spannable.setSpan(ForegroundColorSpan(color), start, length, spanType)
         return spannable
     }
}