package com.example.garam.jeongoo.home.itemEnrollMent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.garam.jeongoo.R

class ItemEnrollActivity : AppCompatActivity() {

    fun replaceFragment(fragment: Fragment,parentFragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out)
            add(R.id.enrollFrameLayout,fragment)
            hide(parentFragment)
            commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_enroll)

        val enroll = EnrollFragment()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.enrollFrameLayout,enroll).commit()

        }
    }
}