package com.ipsoft.mysubscribersapp.ui.subscriber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.ipsoft.mysubscribersapp.R
import com.ipsoft.mysubscribersapp.data.db.AppDatabase
import com.ipsoft.mysubscribersapp.data.db.dao.SubscriberDao
import com.ipsoft.mysubscribersapp.databinding.SubscriberFragmentBinding
import com.ipsoft.mysubscribersapp.extension.hideKeyboard
import com.ipsoft.mysubscribersapp.repository.DatabaseDataSource
import com.ipsoft.mysubscribersapp.repository.SubscriberRepository

class SubscriberFragment : Fragment() {

    private var _binding: SubscriberFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SubscriberViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val subscriberDao: SubscriberDao =
                    AppDatabase.getInstance(requireContext()).subscriberDao
                val repository: SubscriberRepository = DatabaseDataSource(subscriberDao)
                return SubscriberViewModel(repository) as T
            }
        }
    }
    private val args: SubscriberFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SubscriberFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.subscriber?.let { subscriber ->
            binding.buttonSubscriber.text = getString(R.string.subscriber_button_update)
            binding.inputName.setText(subscriber.name)
            binding.inputEmail.setText(subscriber.email)

            binding.buttonDelete.visibility = View.VISIBLE

        }
        observeEvents()
        setListeners()
    }

    private fun observeEvents() {
        viewModel.subscriberStateEventData.observe(viewLifecycleOwner) { subscriberState ->
            when (subscriberState) {
                is SubscriberViewModel.SubscriberState.Inserted,
                is SubscriberViewModel.SubscriberState.Updated,
                is SubscriberViewModel.SubscriberState.Deleted -> {
                    clearFields()
                    hideKeyboard()
                    requireView().requestFocus()
                    findNavController().popBackStack()
                }
            }

        }
        viewModel.messageEventData.observe(viewLifecycleOwner) { stringResId ->
            Snackbar.make(requireView(), stringResId, Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun clearFields() {
        binding.inputName.text?.clear()
        binding.inputEmail.text?.clear()
    }

    private fun hideKeyboard() {
        val parentActivity = requireActivity()
        if (parentActivity is AppCompatActivity) {
            parentActivity.hideKeyboard()
        }
    }

    private fun setListeners() {
        binding.buttonSubscriber.setOnClickListener {
            val name = binding.inputName.text.toString()
            val email = binding.inputEmail.text.toString()

            viewModel.addOrUpdateSubscriber(name, email, args.subscriber?.id ?: 0)
        }
        binding.buttonDelete.setOnClickListener {
            viewModel.removeSubscriber(args.subscriber?.id ?: 0)
        }
    }


}