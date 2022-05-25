package me.berfini.household.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.berfini.household.R
import me.berfini.household.data.CharacterViewModel
import me.berfini.household.data.SharedViewModel
import me.berfini.household.databinding.StuffFragmentBinding

class StuffFragment : Fragment() {
    private lateinit var binding: StuffFragmentBinding
    private lateinit var viewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.stuff_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        viewModel = sharedViewModel.selectedViewModel
        binding.viewModel = viewModel
    }
}