package com.ipsoft.mysubscribersapp.ui.subscriber

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ipsoft.mysubscribersapp.data.db.entity.SubscriberEntity
import com.ipsoft.mysubscribersapp.databinding.SubscriberItemBinding

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    My Subscribers App
 *  Date:       11/02/2021
 */

class SubscriberListAdapter(
    private val subscribers: List<SubscriberEntity>
) : RecyclerView.Adapter<SubscriberListAdapter.SubscriberViewHolder>() {
    private lateinit var binding: SubscriberItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        binding = SubscriberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewRoot = binding.root
        return SubscriberViewHolder(viewRoot)
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        holder.bindView(subscribers[position])
    }

    override fun getItemCount() = subscribers.size

    inner class SubscriberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewSubscriberName: TextView = binding.textSubscriberName
        private val textViewSubscriberEmail: TextView = binding.textSubscriberEmail
        fun bindView(subscriber: SubscriberEntity) {

            textViewSubscriberName.text = subscriber.name
            textViewSubscriberEmail.text = subscriber.email

        }

    }
}