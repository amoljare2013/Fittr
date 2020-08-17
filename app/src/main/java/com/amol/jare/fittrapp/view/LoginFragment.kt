package com.amol.jare.fittrapp.view

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.amol.jare.fittrapp.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        view.findViewById<Button>(R.id.button1).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            login()
        }
    }

    fun login() {
        Log.d(TAG, "Login")

        if (!validate()) {
            onLoginFailed()
            return
        } else {
            onLoginSuccess()
        }
    }

    fun validate(): Boolean {
        var valid = true

        val email = edtUsername!!.text.toString()
        val password = edtPassword!!.text.toString()

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtUsername!!.error = "enter a valid email address"
            valid = false
        } else {
            edtUsername!!.error = null
        }

        if (password.isEmpty() || password.length < 4 || password.length > 10) {
            edtPassword!!.error = "between 4 and 10 alphanumeric characters"
            valid = false
        } else {
            edtPassword!!.error = null
        }
        return valid
    }

    fun onLoginSuccess() {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

    fun onLoginFailed() {
        Toast.makeText(requireContext(), "Login failed", Toast.LENGTH_LONG).show()
    }
}
