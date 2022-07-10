package rr.chrd.xosotphcm.dashboard

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpActivity
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpType
import rr.chrd.xosotphcm.R
import rr.chrd.xosotphcm.utils.Utilities


class Splash : JumpActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        splashAction(JumpType.JUMP_LINK, 3){ _, _ ->
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    startActivity(Utilities.getStartIntent(this))
                    finish()
                },1500
            )
        }
    }
}