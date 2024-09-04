package com.myapplication.presentation.screen.contactsScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.databinding.RvItemBinding

class ContactsAdapter : ListAdapter<ContactEntity, ContactsAdapter.ViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(item)
            }
        }
        holder.itemView.setOnLongClickListener {
            onItemLongClickListener?.let {
                it(item)
            }
            true
        }
    }

    class ViewHolder(binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.rvName
        private val number = binding.rvNumber

        fun bind(item: ContactEntity) {
            name.text = item.name
            number.text = item.number
        }
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ContactEntity>() {
        override fun areItemsTheSame(oldItem: ContactEntity, newItem: ContactEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ContactEntity, newItem: ContactEntity): Boolean {
            return oldItem == newItem
        }
    }

    private var onItemClickListener: ((ContactEntity) -> Unit)? = null
    private var onItemLongClickListener: ((ContactEntity) -> Unit)? = null

    fun setOnItemClickListener(listener: (ContactEntity) -> Unit) {
        onItemClickListener = listener
    }

    fun setOnLongItemClickListener(listener: (ContactEntity) -> Unit) {
        onItemLongClickListener = listener
    }
}