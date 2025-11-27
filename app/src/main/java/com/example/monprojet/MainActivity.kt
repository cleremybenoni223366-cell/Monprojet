package com.example.monprojet

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {
    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val data: Intent? = result.data
        if (data != null) { // Check that we have data returned
            val question = data.getStringExtra("question_Key") // 'string1' needs to match the key we used when we put the string in the Intent
            val reponse = data.getStringExtra("reponse_Key")

            // Log the value of the strings for easier debugging
            Log.i("MainActivity", "question: $question")
            Log.i("MainActivity", "reponse: $reponse")

            // Set the value: $string2")
        } else {
            Log.i("MainActivity", "Returned null data from AddCardActivity")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val questionText = findViewById<TextView>(R.id.question)
        val reponseText = findViewById<TextView>(R.id.reponse)

        val icone = findViewById<ImageView>(R.id.imageView)


        icone.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            resultLauncher.launch(intent)
        }

        questionText.setOnClickListener {
            questionText.visibility = View.INVISIBLE
            reponseText.visibility = View.VISIBLE
        }

        reponseText.setOnClickListener {
            reponseText.visibility = View.VISIBLE
            questionText.visibility = View.INVISIBLE
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}


