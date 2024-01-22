package com.example.businesscard

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class WriteEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_email)
        val sendButton = findViewById<Button>(R.id.sendBtn)
        val sendToInput = findViewById<TextInputLayout>(R.id.sendTo)
        val mailMessageInput = findViewById<EditText>(R.id.mailText)
        val subjectInput = findViewById<TextInputLayout>(R.id.subject)
        sendButton.setOnClickListener {
            if (sendToInput?.editText?.text.isNullOrBlank() || mailMessageInput?.text.isNullOrBlank()) {
                Toast.makeText(this, "You should fill 'From' and 'Message' fields", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.setData(Uri.parse("mailto:${sendToInput.editText?.text.toString()}"))
                intent.putExtra(Intent.EXTRA_SUBJECT, subjectInput.editText?.text.toString())
                intent.putExtra(Intent.EXTRA_TEXT, mailMessageInput.text)
                startActivity(intent)
            }
        }

    }
}