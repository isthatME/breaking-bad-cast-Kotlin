package com.kotlinjsonexample

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shakil.kotlinjsonexample.R
import com.google.android.material.textfield.TextInputLayout
import com.kotlinjsonexample.Adapter.CharacterAdapter
import com.kotlinjsonexample.Common.Common
import com.kotlinjsonexample.Interface.RetrofitService
import com.kotlinjsonexample.Model.Character
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        loginBtn.setOnClickListener(){

            val email: EditText = findViewById(R.id.email);
            val nickname: EditText = findViewById(R.id.nickname);
            val password: EditText = findViewById(R.id.password);
            val nicknameFormated = nickname.text.toString();

            if(email.text.toString().equals("gui@gui.com") && password.text.toString().equals("123") && !nickname.text.toString().isEmpty()){
                val intent = Intent(this@MainActivity, CharacterList::class.java);
                intent.putExtra("nickname", nicknameFormated)
                startActivity(intent);
            }else{
                Toast.makeText(this, "Campos inválidos ou vazios", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
