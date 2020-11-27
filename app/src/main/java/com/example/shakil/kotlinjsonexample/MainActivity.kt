package com.example.shakil.kotlinjsonexample

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shakil.kotlinjsonexample.Adapter.CharacterAdapter
import com.example.shakil.kotlinjsonexample.Common.Common
import com.example.shakil.kotlinjsonexample.Interface.RetrofitService
import com.example.shakil.kotlinjsonexample.Model.Character
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter : CharacterAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MutableList<Character>>, response: Response<MutableList<Character>>) {
                adapter = CharacterAdapter(baseContext, response.body() as MutableList<Character>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter

                dialog.dismiss()
            }

        })
    }
}
