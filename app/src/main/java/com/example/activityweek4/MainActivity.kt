package com.example.activityweek4


import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


// Hardcoded username and password
private const val validUsername = "android"
private const val validPassword = "login123"

class MainActivity : AppCompatActivity() {
    // Declare variables for the username, password fields, and the login button
    private lateinit var usernameField : EditText
    private lateinit var passwordField : EditText
    private lateinit var loginBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    @SuppressLint("WrongConstant", "SetTextI18n")
    // Function that handles login logic
    fun login(view: View) {
        // Initialize the username and password fields by finding them in the layout
        usernameField = findViewById(R.id.username)
        passwordField = findViewById(R.id.password)
        // Initialize the login button
        loginBtn = findViewById(R.id.button)

        // Set an onClickListener to handle login when the button is clicked
        loginBtn.setOnClickListener {
            // Get the input values from the username and password fields
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            // Check if the input matches the hardcoded valid credentials
            val isLoginValid = username == validUsername && password == validPassword

            // Create a Toast message (a small pop-up message) to display login status
            val toast = Toast(applicationContext)

            // Inflate a custom layout for the Toast from XML
            val toastView: View = LayoutInflater.from(applicationContext).inflate(R.layout.custom_toast_layout, null)

            // Find the TextView in the custom layout if you want to modify it programmatically
            val toastText: TextView = toastView.findViewById(R.id.custom_toast_text)

            // Update the Toast message and background based on the login result
            if (isLoginValid) {
                // Login successful
                toastText.text =   "Login successful!"
                toastText.background = ColorDrawable(Color.parseColor("#008000")) // Green background
            } else {
                // Login failed
                toastText.text =   "Invalid username or password"
                toastText.background = ColorDrawable(Color.parseColor("#FF0000")) // Red background
            }

            // Set the custom layout as the view for the Toast
            toast.view = toastView

            // Position the Toast at the top center of the screen
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)

            // Set the Toast duration to short
            toast.duration = Toast.LENGTH_SHORT

            // Show the Toast
            toast.show()



        }



    }
}