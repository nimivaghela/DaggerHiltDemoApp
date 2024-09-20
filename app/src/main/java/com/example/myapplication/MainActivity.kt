package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.PostAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.CompanyResponseItem
import com.example.myapplication.viewmodels.CompanyViewModel
import com.google.gson.JsonObject
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter

//    private var companyViewModel: CompanyViewModel by viewModelStore

    lateinit var companyViewModel: CompanyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        companyViewModel = ViewModelProvider(this)[CompanyViewModel::class.java]
        runBlocking {
            companyViewModel.getCompanyDataPost()
        }

        companyViewModel.response.observe(this, Observer { response ->
//            postAdapter.setData(response as ArrayList<CompanyResponseItem>)
            setUi(
                response as ArrayList<CompanyResponseItem>
            )
        })
    }

    fun setUi(
        list: ArrayList<CompanyResponseItem>
    ) {
        postAdapter = PostAdapter(this, list)
        binding.rvCompany.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }

}

