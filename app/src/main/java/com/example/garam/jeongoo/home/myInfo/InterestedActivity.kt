package com.example.garam.jeongoo.home.myInfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.garam.jeongoo.PreferenceManager
import com.example.garam.jeongoo.R
import com.example.garam.jeongoo.databinding.ActivityInterestedBinding

class InterestedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInterestedBinding
    private lateinit var viewModel: MyInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_interested)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(MyInfoViewModel::class.java)
        binding.viewModel = viewModel

        val preferenceManager = PreferenceManager()
        viewModel.userId.value = preferenceManager.getId(this,"userId")
        viewModel.token.value = preferenceManager.getToken(this,"token")

        viewModel.getInterestedList()
    }
}