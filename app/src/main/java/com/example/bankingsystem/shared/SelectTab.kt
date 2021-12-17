package com.example.bankingsystem.shared
import android.content.Context
import android.graphics.PorterDuff
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.bankingsystem.R
import com.example.bankingsystem.databinding.TabBarIncludeBinding

object SelectTab {
    fun makeTabActive(
        context: Context,
        tabBarIncludeBinding: TabBarIncludeBinding,
        image: ImageView,
        text: TextView
    ) {
        makeAllTabsInactive(context, tabBarIncludeBinding)
        image.setColorFilter(ContextCompat.getColor(context, R.color.logInButtonColor), PorterDuff.Mode.SRC_IN)
        text.setTextColor(ContextCompat.getColor(context,R.color.logInButtonColor))
    }

    private fun makeAllTabsInactive(context: Context, tabBarIncludeBinding: TabBarIncludeBinding) {
        tabBarIncludeBinding.homeImage.setColorFilter(
            ContextCompat.getColor(context, R.color.seek_bar_background),
            PorterDuff.Mode.MULTIPLY
        )
        tabBarIncludeBinding.homeText.setTextColor(context.getColor(R.color.seek_bar_background))
        tabBarIncludeBinding.settingsImage.setColorFilter(
            ContextCompat.getColor(
                context,
                R.color.seek_bar_background
            ), PorterDuff.Mode.MULTIPLY
        )
        tabBarIncludeBinding.settingsText.setTextColor(context.getColor(R.color.seek_bar_background))
        tabBarIncludeBinding.depositImage.setColorFilter(
            ContextCompat.getColor(
                context,
                R.color.seek_bar_background
            ), PorterDuff.Mode.MULTIPLY
        )
        tabBarIncludeBinding.depositText.setTextColor(context.getColor(R.color.seek_bar_background))
        tabBarIncludeBinding.transactionImage.setColorFilter(
            ContextCompat.getColor(
                context,
                R.color.seek_bar_background
            ), PorterDuff.Mode.MULTIPLY
        )
        tabBarIncludeBinding.transactionText.setTextColor(context.getColor(R.color.seek_bar_background))
    }
}