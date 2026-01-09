package com.curdu.cafeflow.a_views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curdu.cafeflow.b_viewmodels.RegistreVM
import com.curdu.cafeflow.databinding.ActivityRegistreBinding

class RegistreActivity : AppCompatActivity() {

    private val registreViewModel : RegistreVM by viewModels()
    private lateinit var binding: ActivityRegistreBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistreBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.registreButton.setOnClickListener {
            val nom = binding.nomRegistreEditText.text.toString()
            val email = binding.emailRegistreEditText.text.toString()
            val contrasenya = binding.contrasenyaRegistreEditText.text.toString()
            try{
                registreViewModel.registrarUsuari(this, nom,email,contrasenya)
                Toast.makeText(this, "Usuari registrat correctament", Toast.LENGTH_LONG).show()
                Log.println(Log.INFO, "Registre", "Usuari registrat correctament")
            }catch (e: RuntimeException) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                Log.println(Log.WARN, "Registre", e.message.toString())
            }
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.iniciarSessioLinkText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}