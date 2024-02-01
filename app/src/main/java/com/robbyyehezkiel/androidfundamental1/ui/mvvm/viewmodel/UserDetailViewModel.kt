package com.robbyyehezkiel.androidfundamental1.ui.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.robbyyehezkiel.androidfundamental1.data.model.User
import com.robbyyehezkiel.androidfundamental1.data.repository.GitHubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserDetailViewModel(
    private val gitHubRepository: GitHubRepository,
) : BaseViewModel() {

    private val _userDetail = MutableLiveData<User>()
    val userDetail: LiveData<User> = _userDetail

    fun fetchUserDetail(username: String) {
        isLoading.value = true
        viewModelScope.launch(exceptionHandler) {
            val userDetails = withContext(Dispatchers.IO) {
                gitHubRepository.getUserDetail(username)
            }
            _userDetail.value = userDetails
        }.invokeOnCompletion {
            isLoading.value = false
        }
    }

}