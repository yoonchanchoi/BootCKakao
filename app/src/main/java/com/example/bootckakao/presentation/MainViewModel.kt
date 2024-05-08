package com.example.bootckakao.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootckakao.domain.search.model.ImageDocumentEntity
import com.example.bootckakao.domain.search.usecase.RequestSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val requestSearchUseCase: RequestSearchUseCase
) : ViewModel() {

    private val _imageDocumentEntities = MutableLiveData<List<ImageDocumentEntity>>()
    val imageDocumentEntities: LiveData<List<ImageDocumentEntity>>
        get() = _imageDocumentEntities

    //스레드 확인 학습을 위해서 남겨 놓은 주석
//    suspend fun test() = coroutineScope { launch {
//        //해당 스레드에 대한 default Dispatchers
//        Log.e("cyc", Thread.currentThread().name)
//    } }

    fun requestSearch(query: String) {
        CoroutineScope(Dispatchers.Default)
        viewModelScope.launch {
            val imageDocumentList = requestSearchUseCase(query).documents
            imageDocumentList.let {
                _imageDocumentEntities.value = it
            }
        }
    }
}
