package com.example.garam.jeongoo.home.itemEnrollMent

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.garam.jeongoo.R

class ItemEnrollFragment : Fragment() {

//    private lateinit var itemEnrollViewModelViewModel: ItemEnrollViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
  //      itemEnrollViewModelViewModel = ViewModelProvider(this.requireActivity()).get(ItemEnrollViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_item_enroll, container, false)

        val nextIntent = Intent(activity,ItemEnrollActivity::class.java)
        startActivity(nextIntent)

        return root
    }
}