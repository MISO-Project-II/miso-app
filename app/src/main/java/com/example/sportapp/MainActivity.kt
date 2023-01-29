package com.example.sportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.sportapp.databinding.ActivityMainBinding
import com.example.sportapp.models.LoginViewModel
import com.example.sportapp.responses.LoginResponse

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.loginResult.observe(this) {
            when (it) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    processLogin(it.data)
                }

                is BaseResponse.Error -> {
                    processError(it.msg)
                }
                else -> {
                    stopLoading()
                }
            }
        }

        binding.login.setOnClickListener {
            doLogin()
        }
    }

    fun doLogin() {
        val username = binding.user.text.toString()
        val pwd = binding.password.text.toString()
        if(username.isNullOrEmpty() || pwd.isNullOrEmpty()){
            processError("Ingrese Usuario y contraseña")
        }else {
            viewModel.loginUser(username = username, pwd = pwd)
        }
    }

    fun showLoading() {
        binding.prgbar.visibility = View.VISIBLE
    }

    fun stopLoading() {
        binding.prgbar.visibility = View.GONE
    }

    fun processLogin(data: LoginResponse?) {
        showToast("Success:" + data?.message)
        if (!data?.token?.isNullOrEmpty()!!) {
            navigateToHome()
        }
    }
    private fun navigateToHome() {
        val inicio = Intent(this, MainActivity2::class.java)
        startActivity(inicio)
    }

    fun processError(msg: String?) {
        showToast("Error:" + msg)
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}