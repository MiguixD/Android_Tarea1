package com.example.tarea1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tarea1.databinding.FragmentRegisterBinding
import com.example.tarea1.viewmodels.RegisterViewModel


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        viewModel.isButtonEnabled.observe(viewLifecycleOwner, object:Observer<Boolean> {
            override fun onChanged(value: Boolean) {
                binding.buttonRegister.isEnabled = value
            }
        })

        binding.textInputEditTextRegisterUser.addTextChangedListener {
            viewModel.onUserTextChanged(it.toString())
        }

        binding.textInputEditTextRegisterPassword.addTextChangedListener {
            viewModel.onPasswordTextChanged(it.toString())
        }

        binding.textInputEditTextRegisterConfirmPassword.addTextChangedListener {
            viewModel.onConfirmPasswordTextChanged(it.toString())
        }
    }
}