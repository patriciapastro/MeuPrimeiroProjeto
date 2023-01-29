package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val result =  intent.getFloatExtra("EXTRA_RESULT",0.1f )
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        tvResult.text = result.toString()

        var classificacao = ""

        classificacao = if(result <18.5f) {
            " Você está abaixo do peso."
        } else  if(result in 18.5f..24.9f) {
            " Você está com o peso dentro do normal."
        }else if (result in 25f..29.9f) {
            " Você está com sobrepreso."
        }else if (result in 30f..39.9f) {
            " Você está com obesidade."
        }else{
            " Você está com obesidade grave."
        }
        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}