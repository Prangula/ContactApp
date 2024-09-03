package com.myapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.data.database.entity.ContactEntity
import com.myapplication.databinding.RvItemBinding

class ContactsAdapter(private val items: List<ContactEntity>) :
    RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            rvName.text = item.name
            rvNumber.text = item.number
        }
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

    private var onItemClickListener: ((ContactEntity) -> Unit)? = null
    private var onItemLongClickListener: ((ContactEntity) -> Unit)? = null

    fun setOnItemClickListener(listener: (ContactEntity) -> Unit) {
        onItemClickListener = listener
    }

    fun setOnLongItemClickListener(listener: (ContactEntity) -> Unit) {
        onItemLongClickListener = listener
    }
}