package study.examples.basic.modules.activity.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasicViewModel : ViewModel() {
    val liveData = MutableLiveData<String>()
    var testField = ""
}