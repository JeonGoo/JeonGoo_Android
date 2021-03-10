package com.example.garam.jeongoo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class JeonGooViewModel(application: Application) : AndroidViewModel(application) {

    val id = MutableLiveData<String>()
    val password = MutableLiveData<String>()

}