package com.example.bootckakao.presentation.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bootckakao.databinding.FragmentSearchBinding
import com.example.bootckakao.domain.search.model.ImageDocument
import com.example.bootckakao.presentation.MainViewModel
import com.example.bootckakao.presentation.search.recyclerview.SearchAdapter
import com.example.bootckakao.presentation.search.recyclerview.SearchFavoriteClickListener
import com.example.bootckakao.util.Constants
import com.example.bootckakao.util.GridSpaceItemDecoration
import com.example.bootckakao.util.Pref
import com.example.bootckakao.util.fromDpToPx
import com.example.bootckakao.util.hideSoftKeyboard
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment(), SearchFavoriteClickListener {

    @Inject
    lateinit var pref: Pref

    private lateinit var binding: FragmentSearchBinding
    private val searchAdapter: SearchAdapter by lazy {
        SearchAdapter(this)
    }


    private val gridSpaceItemDecoration: GridSpaceItemDecoration by lazy {
        GridSpaceItemDecoration(spanCount = 2, spacing = 20f.fromDpToPx())
    }

    private val viewModel: MainViewModel by activityViewModels()
//    private val viewModel: SearchViewModel by viewModels()
    private var query = ""
    private lateinit var imageDocumentEntities: List<ImageDocument>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSearchAdapter()
        setupData()
        setupObserve()
        setupListener()
    }

    private fun setupData() {
        pref.getString(Constants.SAVE_SEARCH)?.let {
            query = it
            if (it.isNotEmpty()) {
                binding.etSearch.setText(query)
                viewModel.requestSearch(query)
            }
        }
    }


    private fun setupObserve() {
        viewModel.imageDocumentEntities.observe(viewLifecycleOwner) {
            Log.e("cyc", "검색 내용 -->${it}")
            searchAdapter.submitList(it)
        }
    }

    private fun setupListener() {
        binding.btnSearch.setOnClickListener {
            query = binding.etSearch.text.toString()
            Log.e("cyc","query-->${query}")
            if (query.isNotEmpty()) {
                Log.e("cyc","돌아간다.")
                Log.e("cyc","query.trim()-->${query.trim()}")
                viewModel.requestSearch(query.trim())
                pref.putData(Constants.SAVE_SEARCH, query.trim())
                binding.etSearch.setText(query.trim())
                binding.etSearch.setSelection(query.trim().length)
                it.hideSoftKeyboard()
            } else {
                Toast.makeText(requireActivity(), "검색어를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setSearchAdapter() {
        val searchManager =
            GridLayoutManager(requireActivity(), 2)
        binding.rv.apply {
            addItemDecoration(gridSpaceItemDecoration)
            layoutManager = searchManager
            adapter = searchAdapter
        }
    }

    override fun onFavoriteItemClick(
        position: Int,
        item: ImageDocument
    ) {
        Log.e("cyc","북마크 체크 관련 리스너")
        viewModel.addOrDelete(position, item)
//        if (item.favorite) {
//            viewModel.deleteBookMark(item.imageUrl)
//            imageDocumentEntities.mapIndexed { index, imageDocument ->
//                if(index==position){
//                    imageDocument.copy(favorite = false)
//                }
//            }
//        } else {
//            Log.e("cyc","북마크 체크 했을때")
//            viewModel.addBookMark(item.copy(favorite = true))
//            imageDocumentEntities.mapIndexed { index, imageDocument ->
//                if(index==position){
//                    imageDocument.copy(favorite = true)
//                }
//            }
//        }
    }

}