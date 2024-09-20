package com.example.myapplication.interfaces

import androidx.lifecycle.LiveData
import com.example.myapplication.model.CompanyResponse
import com.example.myapplication.model.CompanyResponseItem
import com.example.myapplication.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    //    https://jsonplaceholder.typicode.com/

    @GET(Constants.GET_COMPANY_DATA)
    suspend fun getCompanyData(): List<CompanyResponseItem>

}