package com.tegarpenemuan.latihanroomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tegarpenemuan.latihanroomdatabase.room.NoteDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val db by lazy { NoteDB(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val notes = db.noteDao().getNotes()
            Log.d("MainActivity","dbResponse: $notes")
        }
    }

    private fun setupListener() {
        button_create.setOnClickListener {
            startActivity(Intent(this,EditActivity::class.java))
        }
    }
}