package com.example.project

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.project.databinding.ActivityDetailBinding
import vm.ActivityDetailViewModel
import vm.StartViewModel

class ActivityDetailActivity() : AppCompatActivity() {

    private val datasource: StartViewModel = StartViewModel()
    lateinit var binding : ActivityDetailBinding
    private val viewModel : ActivityDetailViewModel = ActivityDetailViewModel(datasource)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val activityName = binding.textCategoryName
        val activityDescription = binding.activityDetailDescription
        val activityPrice = binding.textPrice

        intent.extras?.let { it ->
            val id = it.getInt("ID_ACTIVITY")
            val currentActivity = datasource.getActivityForId(id)
            activityName.text = currentActivity?.activity
            activityDescription.text = currentActivity?.title
            activityPrice.text = currentActivity?.price
        }
    }

    }