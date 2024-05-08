package com.example.bootckakao.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bootckakao.databinding.FragmentSearchBinding
import com.example.bootckakao.domain.search.model.ImageDocumentEntity
import com.example.bootckakao.util.GridSpaceItemDecoration
import com.example.bootckakao.presentation.MainViewModel
import com.example.bootckakao.presentation.search.recyclerview.SearchAdapter
import com.example.bootckakao.presentation.search.recyclerview.SearchFavoriteClickListener
import com.example.bootckakao.util.Constants
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

    private val viewModel: MainViewModel by activityViewModels()
    private var query = ""

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
            searchAdapter.submitList(it)
        }
    }

    private fun setupListener() {
        binding.btnSearch.setOnClickListener {
            query = binding.etSearch.text.toString()
            if (!query.isNullOrEmpty()) {
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
            layoutManager = searchManager
            adapter = searchAdapter
            addItemDecoration(GridSpaceItemDecoration(spanCount = 2, spacing = 20f.fromDpToPx()))
//            val spanCount = 2
//            val space = 20
//            addItemDecoration(GridSpaceItemDecoration(spanCount, space))
        }
    }

    override fun onFavoriteItemClick(
        compoundButton: CompoundButton,
        isChecked: Boolean,
        position: Int,
        item: ImageDocumentEntity
    ) {
        if (isChecked) {
            item.favorite = true
            viewModel.addBookMark(item)
        } else {
            item.favorite = false
            viewModel.deleteBookMark(item.imageUrl)
        }
    }
}