package com.example.tarea1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tarea1.R
import com.example.tarea1.databinding.FragmentLoginBinding
import com.example.tarea1.viewmodels.LoginViewModel


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        viewModel.isButtonEnabled.observe(viewLifecycleOwner, object:Observer<Boolean> {
            override fun onChanged(value: Boolean) {
                binding.buttonLogin.isEnabled = value
            }
        })

        binding.textInputEditTextLoginUser.addTextChangedListener {
            viewModel.onUserTextChanged(it.toString())
        }

        binding.textInputEditTextLoginPassword.addTextChangedListener {
            viewModel.onPasswordTextChanged(it.toString())
        }
    }
}