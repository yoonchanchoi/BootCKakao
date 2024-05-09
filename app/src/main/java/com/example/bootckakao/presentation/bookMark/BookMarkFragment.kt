package com.example.bootckakao.presentation.bookMark

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bootckakao.databinding.FragmentBookMarkBinding
import com.example.bootckakao.domain.search.model.ImageDocument
import com.example.bootckakao.presentation.search.recyclerview.BookMarkAdapter
import com.example.bootckakao.presentation.search.recyclerview.BookMarkClickListener
import com.example.bootckakao.util.GridSpaceItemDecoration
import com.example.bootckakao.util.fromDpToPx
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookMarkFragment : Fragment(), BookMarkClickListener {

    private lateinit var binding: FragmentBookMarkBinding

//    private val viewModel: MainViewModel by activityViewModels()
    private val viewModel: BookMarkViewModel by viewModels()
    private val bookMarkAdapter: BookMarkAdapter by lazy {
        BookMarkAdapter(this)
    }
    private val gridSpaceItemDecoration: GridSpaceItemDecoration by lazy {
        GridSpaceItemDecoration(spanCount = 2, spacing = 20f.fromDpToPx())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookMarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBookMarkAdapter()
        setupData()
        setupObserve()
    }

    private fun setupData() {
        viewModel.getAllBookMark()
    }

    private fun setupObserve() {
        viewModel.bookMarkImageDocumentEntities.observe(viewLifecycleOwner) {
            bookMarkAdapter.submitList(it)
        }
    }

    private fun setBookMarkAdapter() {
        val bookMarkManager =
            GridLayoutManager(requireActivity(), 2)
        binding.rv.apply {
            addItemDecoration(gridSpaceItemDecoration)
            layoutManager = bookMarkManager
            adapter = bookMarkAdapter
        }

    }

    override fun onItemLongeClick(position: Int, item: ImageDocument): Boolean {
        viewModel.deleteBookMark(item.imageUrl)
        Log.e("cyc","삭제 롱 클릭")
//        viewModel.getAllBookMark()
        return true
    }
}