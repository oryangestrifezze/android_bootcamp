package com.example.project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ItemActivitiesBinding
import model.ActivityModel

class ActivitieAdapter: RecyclerView.Adapter<ActivitieAdapter.ActivitieAdapterViewHolder>() {
    var listActivities: List<ActivityModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun interface onClick {
        fun activityClicked(activity: ActivityModel)
    }

    var itemClicked: onClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitieAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemActivitiesBinding.inflate(inflater,parent, false)
        return ActivitieAdapterViewHolder(binding, itemClicked)
    }

    override fun onBindViewHolder(holder: ActivitieAdapterViewHolder, position: Int) {
        val item = listActivities[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listActivities.size

    class ActivitieAdapterViewHolder(val binding: ItemActivitiesBinding, val itemClicked: onClick?) : RecyclerView.ViewHolder(binding.root) {

        fun bind(activitie : ActivityModel) {
            binding.textActivitie.text = activitie.activity

            binding.root.setOnClickListener {
                itemClicked?.activityClicked(activitie)
            }
        }
    }
}