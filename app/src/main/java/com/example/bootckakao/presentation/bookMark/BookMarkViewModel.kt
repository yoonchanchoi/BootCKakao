package com.example.bootckakao.presentation.bookMark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootckakao.domain.search.model.ImageDocument
import com.example.bootckakao.domain.search.usecase.DeleteSaveImageDocumentEntityUseCase
import com.example.bootckakao.domain.search.usecase.GetAllSaveImageDocumentEntityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val deleteSaveImageDocumentEntityUseCase: DeleteSaveImageDocumentEntityUseCase,
    private val getAllSaveImageDocumentEntityUseCase: GetAllSaveImageDocumentEntityUseCase
) : ViewModel() {


    private val _bookMarkImageDocumentEntities = MutableLiveData<List<ImageDocument>>()
    val bookMarkImageDocumentEntities: LiveData<List<ImageDocument>>
        get() = _bookMarkImageDocumentEntities

    init {
        getAllBookMark()
    }

    fun deleteBookMark(imageUrl: String) {
        viewModelScope.launch {
            deleteSaveImageDocumentEntityUseCase(imageUrl)
            getAllBookMark()
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