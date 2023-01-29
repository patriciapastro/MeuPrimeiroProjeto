package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edittext_peso)
        val edtaltura: EditText = findViewById(R.id.edittext_altura)
        //val tvResultado : TextView = findViewById(R.id.txtMsg) remover pq esta na prox tela

        btnCalcular.setOnClickListener {
            //pegar os dados inseridos pelo user
            val message: String = edtPeso.text.toString()
            //mostrar uma nova mensagem no TV
            //tvResultado.text = message

            if (edtaltura.text.isNullOrBlank() || edtPeso.text.isNullOrBlank()) {
                Toast.makeText(applicationContext, R.string.error_message, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val altura: Float = edtaltura.text.toString().toFloat()
            val alturaFinal: Float = altura * altura
            val peso: Float = edtPeso.text.toString().toFloat()
            val result: Float = peso / alturaFinal

            // tvResultado.text = result.toString()

            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)
                }
            startActivity(intent)

        }


    }
}