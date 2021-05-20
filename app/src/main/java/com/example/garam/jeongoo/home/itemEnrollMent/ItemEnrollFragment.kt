package com.example.garam.jeongoo.home.itemEnrollMent

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.garam.jeongoo.PreferenceManager
import com.example.garam.jeongoo.R

class ItemEnrollFragment : Fragment() {

    private lateinit var itemEnrollViewModel: ItemEnrollViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        itemEnrollViewModel = ViewModelProvider(this.requireActivity()).get(ItemEnrollViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_item_enroll, container, false)

        val preferenceManager = PreferenceManager()
        itemEnrollViewModel.token.value = preferenceManager.getToken(this.requireContext(),"token")
        itemEnrollViewModel.userId.value = preferenceManager.getId(this.requireContext(),"userId")

        val nextIntent = Intent(activity,ItemEnrollActivity::class.java)
        startActivity(nextIntent)

        return root
    }
}