package com.project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val repository = MainRepository()
    val listPosts = MutableLiveData<List<PostResponse>>()

    fun getPosts()  {
        viewModelScope.launch {
           val result = repository.getPosts()
            listPosts.value = result
        }
    }
}