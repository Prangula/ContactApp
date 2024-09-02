package com.myapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.R
import com.myapplication.data.database.ContactItem
import com.myapplication.databinding.RvItemBinding

class ContactsAdapter(private val items: List<ContactItem>) :
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
        holder.itemView.apply {
            setOnClickListener {
                onItemClickListener?.let {
                    it(item)
                }
            }
        }
    }

    private var onItemClickListener: ((ContactItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (ContactItem) -> Unit) {
        onItemClickListener = listener
    }

}