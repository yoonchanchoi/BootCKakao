package com.example.bootckakao.data.model.remote

import java.text.SimpleDateFormat


fun String.toChangeDate(): String {
    if (this.isNullOrEmpty()) {
        return "값이 없습니다."
    }
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    val newDateFormat = SimpleDateFormat("yyyy-mm-dd HH:mm:ss")
    try {
        val date = dateFormat.parse(this)
        return newDateFormat.format(date)
    } catch (e: Exception) {
        return this.substring(0, 18)
    }
}