package rr.chrd.xosotphcm.utils

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import rr.chrd.xosotphcm.R
import rr.chrd.xosotphcm.dashboard.MainActivity

class Utilities {

    companion object{

        var dataImg = arrayListOf(
            R.drawable.info1,
            R.drawable.info2,
            R.drawable.info3,
        )

        fun ImageView.glideImage(image: Any?) = Glide.with(this).load(image).into(this)
        fun getStartIntent (context: Context) = Intent(context, MainActivity::class.java)

        var histoIcon = arrayListOf(
            R.drawable.history_icon,
            R.drawable.history_icon,
            R.drawable.history_icon)

        var stratIcon = arrayListOf(
            R.drawable.strat_icon,
            R.drawable.strat_icon,
            R.drawable.strat_icon,
            R.drawable.strat_icon,
            R.drawable.strat_icon,
            R.drawable.strat_icon,
            R.drawable.strat_icon,
            R.drawable.strat_icon,

        )

        fun onBackStacked(
            tag: String,
            fragmentManager: FragmentManager?){

            fragmentManager?.popBackStack(
                tag,
                FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}