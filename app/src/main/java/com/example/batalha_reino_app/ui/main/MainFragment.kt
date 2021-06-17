 package com.example.batalha_reino_app.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.batalha_reino_app.R
import com.example.batalha_reino_app.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener(){
            it.findNavController().navigate(R.id.action_mainFragment_to_battleFragment)
        }



        val textView: TextView = binding.txtVCharsInfoRight
        viewModel.txtcharsInfoRight.observe(viewLifecycleOwner, Observer {
           textView.text = it
        })

        val textView2: TextView = binding.txtVCharsInfoLeft
        viewModel.txtcharsInfoLeft.observe(viewLifecycleOwner, Observer {
            textView2.text = it
        })

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}