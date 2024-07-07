package com.robbyyehezkiel.androidfundamental1.ui.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.robbyyehezkiel.androidfundamental1.R
import com.robbyyehezkiel.androidfundamental1.data.api.RetrofitService
import com.robbyyehezkiel.androidfundamental1.data.repository.GitHubUserRepository
import com.robbyyehezkiel.androidfundamental1.databinding.ActivityUserDetailBinding
import com.robbyyehezkiel.androidfundamental1.ui.mvvm.factory.ViewModelFactory
import com.robbyyehezkiel.androidfundamental1.ui.mvvm.viewmodel.UserDetailViewModel
import com.robbyyehezkiel.androidfundamental1.ui.view.fragments.FollowFragment
import com.robbyyehezkiel.androidfundamental1.utils.SnackBarUtil

class UserDetailActivity : AppCompatActivity() {
    private var _binding: ActivityUserDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            title = resources.getString(R.string.toolbar_user_detail)
            setDisplayHomeAsUpEnabled(true)
        }

        val username = intent.getStringExtra("USERNAME")
        if (username != null) {
            setupViewModel()
            viewModel.fetchUserDetail(username)
            observeViewModel()
            setupViewPager(username)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun setupViewModel() {
        val gitHubApi = RetrofitService.provideGitHubApi()
        val repository = GitHubUserRepository(gitHubApi)
        viewModel =
            ViewModelProvider(this, ViewModelFactory(repository))[UserDetailViewModel::class.java]
    }

    private fun observeViewModel() {
        viewModel.userDetail.observe(this) { userDetails ->
            binding.apply {
                Glide.with(this@UserDetailActivity)
                    .load(userDetails.avatar_url)
                    .into(imageAvatar)
                textUsername.text = userDetails.login
                textName.text = userDetails.name
                textFollowers.text = userDetails.followers.toString()
                textFollowing.text = userDetails.following.toString()
            }
        }

        viewModel.errorState.observe(this) { error ->
            showErrorSnackBar(error)
        }

        viewModel.isLoadingState.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

    }

    private fun setupViewPager(username: String) {
        val pagerAdapter = UserDetailPagerAdapter(this, username)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.following)
                1 -> getString(R.string.followers)
                else -> ""
            }
        }.attach()
    }

    private fun showErrorSnackBar(message: String) {
        SnackBarUtil.showSnackBar(binding.root, message)
    }

    private inner class UserDetailPagerAdapter(
        activity: AppCompatActivity,
        private val username: String
    ) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> FollowFragment.newInstance(username, isFollowing = true)
                1 -> FollowFragment.newInstance(username, isFollowing = false)
                else -> throw IllegalArgumentException("Invalid position: $position")
            }
        }
    }
}
