package com.example.bootckakao.presentation.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootckakao.domain.search.model.ImageDocument
import com.example.bootckakao.domain.search.usecase.AddSaveImageDocumentEntityUseCase
import com.example.bootckakao.domain.search.usecase.DeleteSaveImageDocumentEntityUseCase
import com.example.bootckakao.domain.search.usecase.RequestSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val requestSearchUseCase: RequestSearchUseCase,
    private val addSaveImageDocumentEntityUseCase: AddSaveImageDocumentEntityUseCase,
    private val deleteSaveImageDocumentEntityUseCase: DeleteSaveImageDocumentEntityUseCase
) : ViewModel() {

    private val _imageDocumentEntities = MutableLiveData<List<ImageDocument>>()
    val imageDocumentEntities: LiveData<List<ImageDocument>>
        get() = _imageDocumentEntities


    fun requestSearch(query: String) {
        viewModelScope.launch {
            val imageDocumentList = requestSearchUseCase(query)
            imageDocumentList.let {
                _imageDocumentEntities.value = it
            }
        }
    }

    fun addBookMark(imageDocumentEntity: ImageDocument) {
        viewModelScope.launch {
            addSaveImageDocumentEntityUseCase(imageDocumentEntity)
        }
    }

    fun deleteBookMark(imageUrl: String) {
        viewModelScope.launch {
            deleteSaveImageDocumentEntityUseCase(imageUrl)
        }
    }

    fun addOrDelete(imageDocumentEntity: ImageDocument) {
        if (imageDocumentEntity.favorite) {
            deleteBookMark(imageDocumentEntity.imageUrl)
        } else {
            Log.e("cyc","북마크 체크 했을때")
            addBookMark(imageDocumentEntity.copy(favorite = true))
        }
    }

}