package rr.chrd.xosotphcm.dashboard

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import rr.chrd.xosotphcm.R

class MainActivity : AppCompatActivity() {

    private var exit = false

    private val currentFragment: NavController by lazy {
        findNavController(R.id.navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (currentFragment.currentDestination?.id == R.id.mainFragment) {
            if (exit) {
                finishAffinity()
                return
            }
            exit = true
            Toast.makeText(this, "Press back again to exit.", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ exit = false }, 2000)
        } else {
            findNavController(R.id.navHostFragment).navigateUp()
        }
    }
}