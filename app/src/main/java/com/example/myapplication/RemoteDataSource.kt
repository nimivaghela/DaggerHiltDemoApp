package com.example.myapplication

import com.example.myapplication.interfaces.APIService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: APIService) {
    suspend fun getCompanyData() = apiService.getCompanyData()
}