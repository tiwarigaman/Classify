package com.mobile.classify

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private val handler = Handler(Looper.myLooper()!!)
    private lateinit var dataLayout : FrameLayout
    private lateinit var shimmerFrameLayout : ShimmerFrameLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment(dayFragment().newInstance("Monday"))

        dataLayout = findViewById(R.id.fragmentContainer)
        shimmerFrameLayout = findViewById(R.id.shimmer_view)
        dataLayout.isVisible = false
        shimmerFrameLayout.startShimmer()

        startShimmer()

        findViewById<ConstraintLayout>(R.id.mon).setOnClickListener {
            startShimmer()
            showFragment(dayFragment().newInstance("Monday"))
        }

        findViewById<ConstraintLayout>(R.id.tues).setOnClickListener {
            startShimmer()
            showFragment(dayFragment().newInstance("Tuesday"))
        }

        findViewById<ConstraintLayout>(R.id.wed).setOnClickListener {
            startShimmer()
            showFragment(dayFragment().newInstance("Wednesday"))
        }

        findViewById<ConstraintLayout>(R.id.thu).setOnClickListener {
            startShimmer()
            showFragment(dayFragment().newInstance("Thursday"))
        }

        findViewById<ConstraintLayout>(R.id.fri).setOnClickListener {
            startShimmer()
            showFragment(dayFragment().newInstance("Friday"))
        }

        findViewById<ConstraintLayout>(R.id.sat).setOnClickListener {
            startShimmer()
            showFragment(dayFragment().newInstance("Saturday"))
        }
    }

    private fun startShimmer() {

        handler.postDelayed({
            dataLayout.isVisible = true
        },2000)
    }

    private fun showFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
        findViewById<FrameLayout>(R.id.fragmentContainer).visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        // Remove any pending runnables to prevent memory leaks
        handler.removeCallbacksAndMessages(null)
    }
}