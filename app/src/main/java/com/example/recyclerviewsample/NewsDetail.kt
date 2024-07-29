package com.example.recyclerviewsample

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(findViewById(R.id.my_toolbar))

        val newsHeading = findViewById<TextView>(R.id.new_Heading)
        val newsImage = findViewById<ImageView>(R.id.new_Image)
        val newsContent = findViewById<TextView>(R.id.new_Content)

        val heading = intent.getStringExtra("heading")
        val image = intent.getIntExtra("imageId", R.drawable.img1)
        val content = intent.getStringExtra("newsContent")

        newsHeading.text = heading
        newsImage.setImageResource(image)
        newsContent.text = content
    }
}