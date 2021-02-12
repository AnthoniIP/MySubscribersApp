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

    private val viewModel: SubscriberListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val subscriberDao: SubscriberDao =
                    AppDatabase.getInstance(requireContext()).subscriberDao
                val repository: SubscriberRepository = DatabaseDataSource(subscriberDao)
                return SubscriberListViewModel(repository) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SubscriberListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModelEvents()
        
    }
    private fun observeViewModelEvents() {
        viewModel.allSubscribersEvent.observe(viewLifeCycleOwner) { allSubscribers ->
            val subscriberListAdapter = SubscriberListAdapter(allSubscribers)
            with(recyclerSubscriber){
            setHasFixedSize(true)
            adapter = subscriberListAdapter
        }

            }
        

    }


}