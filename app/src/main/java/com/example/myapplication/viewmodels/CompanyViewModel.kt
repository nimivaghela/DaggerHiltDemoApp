package com.example.myapplication.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.CompanyResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(
    private val companyRepository: CompanyRepository
) : ViewModel() {

    private val _response: MutableLiveData<List<CompanyResponseItem>> = MutableLiveData()
    val response: LiveData<List<CompanyResponseItem>> = _response

    suspend fun getCompanyDataPost() {
        companyRepository.getCompanyData().catch { e ->
            Log.e("MainViewModel_ERROR", "getPost: ${e.message}")
        }.collect { response ->
            _response.value = response
            Log.d("TAG", "getCompanyDataPost: $response")
        }
    }
}