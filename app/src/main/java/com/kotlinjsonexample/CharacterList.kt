package com.kotlinjsonexample

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shakil.kotlinjsonexample.R
import com.kotlinjsonexample.Adapter.CharacterAdapter
import com.kotlinjsonexample.Common.Common
import com.kotlinjsonexample.Interface.RetrofitService
import com.kotlinjsonexample.Model.Character
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_character_list.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class CharacterList : AppCompatActivity() {
    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : CharacterAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)

        val intent = getIntent();
        val nicknameWelcome: TextView = findViewById(R.id.nicknameWelcome);
        val nickname: String = intent.getStringExtra("nickname");

        nicknameWelcome.text = "Bem vindo " + nickname;

        mService = Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()
    }
    private fun getAllMovieList() {
        dialog.show()

        mService.getMovieList().enqueue(object : Callback<MutableList<Character>> {
            override fun onFailure(call: Call<MutableList<Character>>, t: Throwable) {
            }

            override fun onResponse(call: Call<MutableList<Character>>, response: Response<MutableList<Character>>) {
                adapter = CharacterAdapter(
                    baseContext,
                    response.body() as MutableList<Character>
                )
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter

                dialog.dismiss()
            }

        })
    }
}