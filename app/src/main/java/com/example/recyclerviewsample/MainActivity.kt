package com.example.recyclerviewsample

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var newArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(findViewById(R.id.my_toolbar))

        myRecyclerView = findViewById(R.id.recyclerView)

        val newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
        )

        val newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing"
        )

        val newsContentArray = arrayOf(
            getString(R.string.news_detail),
            getString(R.string.news_detail),
            getString(R.string.news_detail),
            getString(R.string.news_detail),
            getString(R.string.news_detail),
            getString(R.string.news_detail)
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newArrayList = arrayListOf<News>()

        for(i in newsImageArray.indices){
            val news = News(newsHeadingArray[i],newsImageArray[i],newsContentArray[i])
            newArrayList.add(news)
        }


        val myAdapter = MyAdapter(newArrayList,this)
        myRecyclerView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener{
            override fun onItemClicking(position: Int) {

                val intent = Intent(this@MainActivity,NewsDetail::class.java)
                intent.putExtra("heading",newsHeadingArray[position])
                intent.putExtra("imageId",newsImageArray[position])
                intent.putExtra("newsContent",newsContentArray[position])
                startActivity(intent)

            }

        })

    }
}