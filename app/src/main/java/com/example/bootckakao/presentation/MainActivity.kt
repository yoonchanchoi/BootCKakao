package com.example.bootckakao.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.bootckakao.R
import com.example.bootckakao.databinding.ActivityMainBinding
import com.example.bootckakao.presentation.bookMark.BookMarkFragment
import com.example.bootckakao.presentation.search.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val fragmentManager: FragmentManager by lazy {
        supportFragmentManager
    }
    private val searchFragment: SearchFragment by lazy {
        SearchFragment()
    }
    private val bookMarkFragment: BookMarkFragment by lazy {
        BookMarkFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupFragment()
        setupListener()
    }

    private fun setupFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, searchFragment)
        transaction.commit()
    }

    private fun setupListener() {
        binding.btnSearchFrag.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            setFragment(transaction, FRAGMENT_SEARCH)
        }

        binding.btnBookmarkFrag.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            setFragment(transaction, FRAGMENT_BOOKMARK)
        }

    }

    private fun setFragment(transaction: FragmentTransaction, fragment: Int) {
        when (fragment) {
            FRAGMENT_SEARCH -> {
                transaction.replace(R.id.fragment_container, searchFragment)
                transaction.commit()
            }

            FRAGMENT_BOOKMARK -> {
                transaction.replace(R.id.fragment_container, bookMarkFragment)
                transaction.commit()
            }
        }
    }

    companion object {
        private const val FRAGMENT_SEARCH = 0
        private const val FRAGMENT_BOOKMARK = 1
    }

}



//
//package com.example.bootckakao.presentation
//
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import androidx.fragment.app.FragmentManager
//import androidx.fragment.app.FragmentTransaction
//import com.example.bootckakao.R
//import com.example.bootckakao.databinding.ActivityMainBinding
//import com.example.bootckakao.presentation.bookMark.BookMarkFragment
//import com.example.bootckakao.presentation.search.SearchFragment
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
//
//    private val binding: ActivityMainBinding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }
//
//    private val fragmentManager: FragmentManager by lazy {
//        supportFragmentManager
//    }
//    private val searchFragment: SearchFragment by lazy {
//        SearchFragment()
//    }
//    private val bookMarkFragment: BookMarkFragment by lazy {
//        BookMarkFragment()
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//        setupFragment()
//        setupListener()
//    }
//
//    private fun setupFragment() {
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.fragment_container,  SearchFragment())
//        transaction.commit()
//    }
//
//    private fun setupListener() {
//        binding.btnSearchFrag.setOnClickListener {
//            val transaction = supportFragmentManager.beginTransaction()
//            setFragment(transaction, FRAGMENT_SEARCH)
//        }
//
//        binding.btnBookmarkFrag.setOnClickListener {
//            val transaction = supportFragmentManager.beginTransaction()
//            setFragment(transaction, FRAGMENT_BOOKMARK)
//        }
//
//    }
//
//    private fun setFragment(transaction: FragmentTransaction, tag: String) {
//
//        var fragment = supportFragmentManager.findFragmentByTag(tag)
//
//        supportFragmentManager.fragments.forEach {
//            transaction.hide(it)
//        }
//
//        if(fragment != null){
//            transaction.show(fragment)
//        }else{
//            fragment = when(tag) {
//                FRAGMENT_SEARCH -> SearchFragment()
//                FRAGMENT_BOOKMARK -> BookMarkFragment()
//                else -> return
//            }
//
//            transaction.add(R.id.fragment_container, fragment, tag)
//        }
//        transaction.commit()
//    }
//
//    companion object {
//        private const val FRAGMENT_SEARCH = "fragment_search"
//        private const val FRAGMENT_BOOKMARK = "fragment_bookmark"
//    }
//
//}