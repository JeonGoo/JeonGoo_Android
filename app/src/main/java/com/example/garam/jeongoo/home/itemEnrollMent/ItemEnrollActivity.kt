package com.example.garam.jeongoo.home.itemEnrollMent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.garam.jeongoo.R

class ItemEnrollActivity : AppCompatActivity() {
    private lateinit var itemEnrollViewModelViewModel: ItemEnrollViewModel

    fun replaceFragment(fragment: Fragment,parentFragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out)
            add(R.id.enrollFrameLayout,fragment)
            hide(parentFragment)
            commit()
        }
    }

    fun testReplaceFragment(fragment: Fragment,parentFragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(R.anim.slide_in,R.anim.fade_out,R.anim.fade_in,R.anim.slide_out)
            show(fragment)
            hide(parentFragment)
            commit()
        }
    }

    lateinit var enroll : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_enroll)

        itemEnrollViewModelViewModel = ViewModelProvider(this).get(ItemEnrollViewModel::class.java)

        enroll = EnrollFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.enrollFrameLayout,enroll).commit()

        }
    }
}