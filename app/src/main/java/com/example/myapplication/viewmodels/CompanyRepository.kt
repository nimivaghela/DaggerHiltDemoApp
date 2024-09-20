package com.example.myapplication.viewmodels

import com.example.myapplication.interfaces.APIService
import com.example.myapplication.model.CompanyResponse
import com.example.myapplication.model.CompanyResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CompanyRepository @Inject constructor(private val apiService: APIService) {

    fun getCompanyData(): Flow<List<CompanyResponseItem>> = flow {
        val response = apiService.getCompanyData()
        emit(response)
    }.flowOn(Dispatchers.IO)
}