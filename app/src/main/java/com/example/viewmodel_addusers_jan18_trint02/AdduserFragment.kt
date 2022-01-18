package com.example.viewmodel_addusers_jan18_trint02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel_addusers_jan18_trint02.databinding.FragmentAdduserBinding

class AdduserFragment : Fragment() {

    private var _binding : FragmentAdduserBinding? = null
    private val binding : FragmentAdduserBinding get() = _binding!!

    private lateinit var viewModel : UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdduserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[UserViewModel::class.java]
        with(binding) {
            btnAddUser.setOnClickListener {

                var firstName = tilFirstName.editText?.text.toString()
                var lastName = tilLastName.editText?.text.toString()
                var newUser = User(firstName, lastName)

                viewModel.addUser(newUser)

//                viewModel.user.observe(viewLifecycleOwner, { user->
//                    binding.tilFirstName.editText?.setText(user)
//
//                })
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container_view, DisplayusersFragment::class.java, null)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}