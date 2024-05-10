package com.mobile.classify

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ConstraintLayout>(R.id.mon).setOnClickListener {
            showFragment(dayFragment().newInstance("monday"))
        }

        findViewById<ConstraintLayout>(R.id.tues).setOnClickListener {
            showFragment(dayFragment().newInstance("tuesday"))
        }

        findViewById<ConstraintLayout>(R.id.wed).setOnClickListener {
            showFragment(dayFragment().newInstance("wednesday"))
        }

        findViewById<ConstraintLayout>(R.id.thu).setOnClickListener {
            showFragment(dayFragment().newInstance("thursday"))
        }

        findViewById<ConstraintLayout>(R.id.fri).setOnClickListener {
            showFragment(dayFragment().newInstance("friday"))
        }

        findViewById<ConstraintLayout>(R.id.sat).setOnClickListener {
            showFragment(dayFragment().newInstance("saturday"))
        }
    }

    private fun showFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
        findViewById<FrameLayout>(R.id.fragmentContainer).visibility = View.VISIBLE
    }
}