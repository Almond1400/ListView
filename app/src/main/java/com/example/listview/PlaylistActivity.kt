package com.example.listview

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlaylistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_playlist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent = this.intent
        val action = intent.getStringExtra("Action")
        var items = listOf<ListItem>()
        when(action)
        {
            "Action1" -> {
                items = listOf(
                    ListItem(R.drawable.nautilus,"Иван Человеков","m1"),
                    ListItem(R.drawable.nautilus,"Титаник","m2"),
                    ListItem(R.drawable.nautilus,"Христос (Мне снилось, что...)","m3"),
                    ListItem(R.drawable.nautilus,"Падший ангел","m4"),
                    ListItem(R.drawable.nautilus,"Скованные одной цепью","m5"),
                    ListItem(R.drawable.nautilus,"Прогулки по воде","m6"),
                    ListItem(R.drawable.nautilus,"Крылья","m7")
                )
            }
            "Action2" -> {

                items = listOf(
                    ListItem(R.drawable.grob,"Зоопарк","m1"),
                    ListItem(R.drawable.grob,"Государство","m2"),
                    ListItem(R.drawable.grob,"Он увидел солнце","m3"),
                    ListItem(R.drawable.grob,"Небо как кофе","m4"),
                    ListItem(R.drawable.grob,"Я иллюзорен","m5"),
                    ListItem(R.drawable.grob,"После нас","m6"),
                    ListItem(R.drawable.grob,"Так (Как в покинутом городе...)","m7")
                )
            }
            "Action3" ->{
                items = listOf(
                ListItem(R.drawable.kino,"Звезда по имени Солнце","m1"),
                ListItem(R.drawable.kino,"Пора","m2"),
                ListItem(R.drawable.kino,"Печаль","m3"),
                ListItem(R.drawable.kino,"Легенда","m4"),
                ListItem(R.drawable.kino,"Кончится лето","m5"),
                ListItem(R.drawable.kino,"Закрой за мной дверь, я ухожу","m6"),
                ListItem(R.drawable.kino,"Последний герой","m7")
                )
            }
        }

        val listView : ListView = findViewById(R.id.lvPl)

        val adapter = AdapterList(this, items)
        listView.adapter = adapter
    }
}