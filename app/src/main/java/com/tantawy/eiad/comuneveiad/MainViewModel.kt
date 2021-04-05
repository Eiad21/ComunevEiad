package com.tantawy.eiad.comuneveiad

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tantawy.eiad.comuneveiad.models.Data
import com.tantawy.eiad.comuneveiad.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val respository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Data> = MutableLiveData()

    fun getPersonList(){
        viewModelScope.launch {
            val response = respository.getData()
            myResponse.value = response
        }
    }
}