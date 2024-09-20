package com.example.myapplication.model


import android.os.Parcelable

data class CompanyResponseItem(
    val address: Address?,
    val company: Company?,
    val email: String?, // Sincere@april.biz
    val id: Int?, // 1
    val name: String?, // Leanne Graham
    val phone: String?, // 1-770-736-8031 x56442
    val username: String?, // Bret
    val website: String? // hildegard.org
)