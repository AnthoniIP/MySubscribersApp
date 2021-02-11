package com.ipsoft.mysubscribersapp.ui.subscriberlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ipsoft.mysubscribersapp.data.db.entity.SubscriberEntity
import com.ipsoft.mysubscribersapp.databinding.SubscriberListFragmentBinding
import com.ipsoft.mysubscribersapp.ui.subscriber.SubscriberListAdapter

class SubscriberListFragment : Fragment() {

    private var _binding: SubscriberListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SubscriberListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val subscriberListAdapter = SubscriberListAdapter(
            listOf(
                SubscriberEntity(1, "Anthoni", "anthoni.ipiranga@gmail.com"),
                SubscriberEntity(2, "matheus", "anthoni.matheus@gmail.com")
            )
        )
        binding.recyclerSubscriber.run {
            setHasFixedSize(true)
            adapter = subscriberListAdapter
        }
    }


}