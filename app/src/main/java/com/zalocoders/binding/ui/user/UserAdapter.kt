package com.zalocoders.binding.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zalocoders.binding.data.model.UserResponseItem
import com.zalocoders.binding.databinding.ListItemBinding

class UserAdapter : ListAdapter<UserResponseItem, UserAdapter.ViewHolder>(UserDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: UserResponseItem) {
            binding.user = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class UserDiffCallback : DiffUtil.ItemCallback<UserResponseItem>() {

    override fun areItemsTheSame(oldItem: UserResponseItem, newItem: UserResponseItem): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: UserResponseItem, newItem: UserResponseItem): Boolean {
        return oldItem.id == newItem.id
    }


}