package com.example.bootckakao.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootckakao.domain.search.model.ImageDocumentEntity
import com.example.bootckakao.domain.search.model.toSaveImageDocumentEntity
import com.example.bootckakao.domain.search.usecase.AddSaveImageDocumentEntityUseCase
import com.example.bootckakao.domain.search.usecase.DeleteSaveImageDocumentEntityUseCase
import com.example.bootckakao.domain.search.usecase.GetAllSaveImageDocumentEntityUseCase
import com.example.bootckakao.domain.search.usecase.RequestSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val requestSearchUseCase: RequestSearchUseCase,
    private val addSaveImageDocumentEntityUseCase: AddSaveImageDocumentEntityUseCase,
    private val deleteSaveImageDocumentEntityUseCase: DeleteSaveImageDocumentEntityUseCase,
    private val getAllSaveImageDocumentEntityUseCase: GetAllSaveImageDocumentEntityUseCase
) : ViewModel() {

    private val _imageDocumentEntities = MutableLiveData<List<ImageDocumentEntity>>()
    val imageDocumentEntities: LiveData<List<ImageDocumentEntity>>
        get() = _imageDocumentEntities

    private val _bookMarkImageDocumentEntities = MutableLiveData<List<ImageDocumentEntity>>()
    val bookMarkImageDocumentEntities: LiveData<List<ImageDocumentEntity>>
        get() = _bookMarkImageDocumentEntities

    //스레드 확인 학습을 위해서 남겨 놓은 주석
//    suspend fun test() = coroutineScope { launch {
//        //해당 스레드에 대한 default Dispatchers
//        Log.e("cyc", Thread.currentThread().name)
//    } }

    fun requestSearch(query: String) {
        viewModelScope.launch {
            val imageDocumentList = requestSearchUseCase(query).documents
            imageDocumentList.let {
                _imageDocumentEntities.value = it
            }
        }
    }

    fun addBookMark(imageDocumentEntity: ImageDocumentEntity) {
        viewModelScope.launch {
            addSaveImageDocumentEntityUseCase(imageDocumentEntity.toSaveImageDocumentEntity())
        }
    }

    fun deleteBookMark(imageUrl: String) {
        viewModelScope.launch {
            deleteSaveImageDocumentEntityUseCase(imageUrl)
        }
    }

    fun getAllBookMark() {
        viewModelScope.launch {
            val bookMarkImageDocumentList = getAllSaveImageDocumentEntityUseCase()
            bookMarkImageDocumentList?.let {
                _bookMarkImageDocumentEntities.value = bookMarkImageDocumentList
            }
        }
    }
}