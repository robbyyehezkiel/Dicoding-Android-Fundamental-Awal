package com.robbyyehezkiel.androidfundamental1.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.robbyyehezkiel.androidfundamental1.data.api.RetrofitService
import com.robbyyehezkiel.androidfundamental1.data.repository.GitHubUserRepository
import com.robbyyehezkiel.androidfundamental1.databinding.ActivityMainBinding
import com.robbyyehezkiel.androidfundamental1.ui.adapter.UserAdapter
import com.robbyyehezkiel.androidfundamental1.ui.mvvm.factory.ViewModelFactory
import com.robbyyehezkiel.androidfundamental1.ui.mvvm.viewmodel.MainViewModel
import com.robbyyehezkiel.androidfundamental1.utils.SnackBarUtil

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setup() {
        setupViewModel()
        setupViews()
    }

    private fun setupViewModel() {
        val gitHubApi = RetrofitService.provideGitHubApi()
        val repository = GitHubUserRepository(gitHubApi)
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(repository)
        )[MainViewModel::class.java]
        observeViewModel()
    }

    private fun setupViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter { user ->
            navigateToUserDetail(user.login)
        }
        binding.recyclerView.adapter = adapter

        binding.buttonSearch.setOnClickListener {
            searchUsers()
        }
    }

    private fun navigateToUserDetail(username: String) {
        val intent = Intent(this, UserDetailActivity::class.java)
        intent.putExtra("USERNAME", username)
        startActivity(intent)
    }

    private fun searchUsers() {
        val query = binding.editTextQuery.text.toString().trim()
        if (query.isNotEmpty()) {
            viewModel.searchUsers(query)
        } else {
            viewModel.showEmptyQueryError()
        }
    }

    private fun observeViewModel() {
        viewModel.user.observe(this) { users ->
            adapter.submitList(users)
        }

        viewModel.errorState.observe(this) { error ->
            showErrorSnackBar(error)
        }

        viewModel.isLoadingState.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }

    private fun showErrorSnackBar(message: String) {
        SnackBarUtil.showSnackBar(binding.root, message)
    }
}
