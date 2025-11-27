package com.example.monprojet

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val questionField = findViewById<EditText>(R.id.editTextText2)
        val reponseField = findViewById<EditText>(R.id.editTextText)
        val saveButton = findViewById<ImageView>(R.id.save)
        val cancelButton = findViewById<ImageView>(R.id.cancel)

        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

        saveButton.setOnClickListener {
            val question = questionField.text.toString()
            val reponse = reponseField.text.toString()

            val data = Intent() // create a new Intent, this is where we will put our data

            data.putExtra(
                "question_Key",
                question
            ) // puts one string into the Intent, with the key as 'string1'

            data.putExtra(
                "reponse_Key",
                reponse
            ) // puts another string into the Intent, with the key as 'string2

            setResult(RESULT_OK, data) // set result code and bundle data for response

            finish() // closes this activity and pass

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}