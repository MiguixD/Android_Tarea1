package com.example.tarea1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tarea1.R
import com.example.tarea1.databinding.FragmentLoginBinding
import com.example.tarea1.viewmodels.LoginViewModel
import com.google.android.material.snackbar.Snackbar


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

        binding.buttonLogin.setOnClickListener {
            if(viewModel.validateLogin()) {
                val snackbar = Snackbar.make(binding.root, R.string.loginSuccessful, Snackbar.LENGTH_SHORT)
                snackbar.show()
            } else {
                val snackbar = Snackbar.make(binding.root, R.string.loginUnsuccessful, Snackbar.LENGTH_SHORT)
                snackbar.show()
            }
        }

        binding.buttonLoginGoogle.setOnClickListener {
            val snackbar = Snackbar.make(binding.root, R.string.functionalityNotImplemented, Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction(R.string.close) {
                snackbar.dismiss()
            }
            snackbar.show()
        }

        binding.textViewLoginCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.actionLoginToRegister)
        }
    }
}