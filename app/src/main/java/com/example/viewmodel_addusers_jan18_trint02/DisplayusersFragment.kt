package com.example.viewmodel_addusers_jan18_trint02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel_addusers_jan18_trint02.databinding.FragmentDisplayusersBinding

class DisplayusersFragment : Fragment() {

    private var _binding : FragmentDisplayusersBinding? = null
    private val binding : FragmentDisplayusersBinding get() = _binding!!

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisplayusersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[UserViewModel::class.java]
        with(binding) {

            viewModel.users.observe(viewLifecycleOwner) { user ->
                tvUsers.text = user.toString()

            }

            btnBack.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}