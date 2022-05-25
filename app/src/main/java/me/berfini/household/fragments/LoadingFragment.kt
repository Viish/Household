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
import me.berfini.household.databinding.AcesFragmentBinding
import me.berfini.household.databinding.LoadingFragmentBinding

class LoadingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<LoadingFragmentBinding>(inflater, R.layout.loading_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}