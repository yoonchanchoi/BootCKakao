package com.example.bootckakao.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.example.bootckakao.R
import com.example.bootckakao.databinding.ActivityMainBinding
import com.example.bootckakao.presentation.BookMark.BookMarkFragment
import com.example.bootckakao.presentation.search.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val transaction: FragmentTransaction by lazy {
        supportFragmentManager.beginTransaction()
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
        transaction.add(R.id.fragment_container, SearchFragment())
        transaction.commit()
    }

    private fun setupListener() {
        binding.btnSearchFrag.setOnClickListener {
            setFragment(FRAGMENT_SEARCH)
        }

        binding.btnBookmarkFrag.setOnClickListener {
            setFragment(FRAGMENT_BOOKMARK)
        }

    }

    private fun setFragment(fragment: Int) {
        when (fragment) {
            FRAGMENT_SEARCH -> {
                transaction.replace(R.id.fragment_container, SearchFragment())
                transaction.commit()
            }

            FRAGMENT_BOOKMARK -> {
                transaction.replace(R.id.fragment_container, BookMarkFragment())
                transaction.commit()
            }
        }
    }

    companion object {
        private const val FRAGMENT_SEARCH = 0
        private const val FRAGMENT_BOOKMARK = 1
    }

}