package com.example.project

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.databinding.ActivityActivitiesListBinding
import model.ActivityModel
import vm.StartViewModel


class ActivitiesListActivity() : AppCompatActivity() {
 val ACTIVITY_ID = "ID_ACTIVITY"

    private  lateinit var binding: ActivityActivitiesListBinding
    private val startViewModel: StartViewModel = StartViewModel()

    private val adapter by lazy { ActivitieAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityActivitiesListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter.itemClicked = ActivitieAdapter.onClick { it
            adapterOnClick(it)
        }

        startViewModel.getActivityList()

        startViewModel.activities.observe(this) {
            if (it.isNotEmpty()) {
                adapter.listActivities = it
            }
        }
    }
    private fun adapterOnClick(activity: ActivityModel) {
        val intent = Intent(this, ActivityDetailActivity()::class.java)
        intent.putExtra(ACTIVITY_ID, activity.id)
        startActivity(intent)
    }
}