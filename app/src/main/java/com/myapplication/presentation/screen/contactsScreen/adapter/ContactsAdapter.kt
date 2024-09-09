package com.myapplication.presentation.screen.contactsScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.databinding.RvItemBinding
import com.myapplication.presentation.model.ContactUi

class ContactsAdapter(
    val onViewClick: (item: ContactUi) -> Unit,
    val onViewLongClick: (item: ContactUi) -> Unit,
) :
    ListAdapter<ContactUi, ContactsAdapter.ViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

        holder.itemView.setOnClickListener {
            onViewClick.invoke(item)
        }
        holder.itemView.setOnLongClickListener {
            onViewLongClick.invoke(item)
            true
        }
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ContactUi>() {
        override fun areItemsTheSame(oldItem: ContactUi, newItem: ContactUi): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ContactUi, newItem: ContactUi): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ContactUi) {
            with(binding) {
                rvName.text = item.name
                rvNumber.text = item.number
            }
        }
    }
}