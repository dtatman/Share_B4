package com.example.share_b4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val PREFS_NAME = "user_prefs"
    private val KEY_IS_LOGGED_IN = "is_logged_in"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Kiểm tra xem người dùng đã đăng nhập chưa
        val sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)) {
            navigateToMainActivity()
        }

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // Kiểm tra tên người dùng và mật khẩu (giả định)
            if (username == "admin" && password == "admin") {
                // Lưu trạng thái đăng nhập vào SharedPreferences
                sharedPreferences.edit().putBoolean(KEY_IS_LOGGED_IN, true).apply()
                navigateToMainActivity()
            } else {
                Toast.makeText(this, "Tên người dùng hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
